package ch.sascha.tbz.views;

import ch.sascha.tbz.data.entity.Employment;
import ch.sascha.tbz.data.entity.Person;
import ch.sascha.tbz.data.service.PersonService;
import ch.sascha.tbz.pojo.PatientType;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

/**
 * Patient form web page
 */
@PageTitle("Patient Form")
@Route(value = "patient-form", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class PatientFormView extends Div {

    /**
     * TextField for firstname
     */
    private TextField firstName = new TextField("First name");
    /**
     * TextField for lastName
     */
    private TextField lastName = new TextField("Last name");
    /**
     * TextField for email
     */
    private EmailField email = new EmailField("Email address");
    /**
     * DatePicker for dateOfBirth
     */
    private DatePicker dateOfBirth = new DatePicker("Birthday");
    /**
     * TextField for phone
     */
    private PhoneNumberField phone = new PhoneNumberField("Phone number");

    /**
     * Button for canceling
     */
    private Button cancel = new Button("Cancel");
    /**
     * Button for saving
     */
    private Button save = new Button("Save");

    private Binder<Person> binder = new Binder(Person.class);

    /**
     * Constructor for the web page
     * @param personService     Autowired personService object
     */
    public PatientFormView(PersonService personService) {
        addClassName("patient-form-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            personService.update(binder.getBean());
            Notification.show(binder.getBean().getClass().getSimpleName() + " details stored.");
            clearForm();
        });
    }

    /**
     * Clears form
     */
    private void clearForm() {
        binder.setBean(new Person());
    }

    /**
     * Creates Title component
     * @return      Custom Component Title
     */
    private Component createTitle() {
        return new H3("Personal information");
    }

    /**
     * Creates form layout.
     * @return          Custom form component
     */
    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        email.setErrorMessage("Please enter a valid email address");
        formLayout.add(firstName, lastName, dateOfBirth, phone, email, createPatientTypeDropDownBox());
        return formLayout;
    }

    /**
     * Creates drop box for patientType enum
     * @return      Custom drop bx component
     */
    private Component createPatientTypeDropDownBox() {
        Select<PatientType> patientTypeStatus = new Select<>();
        patientTypeStatus.setLabel("Patient Type");
        patientTypeStatus.setItems(PatientType.INPATIENT, PatientType.OUTPATIENT);
        return patientTypeStatus;
    }

    /**
     * Creates button layout component
     * @return      Custom layout containing buttons and themes
     */
    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    private static class PhoneNumberField extends CustomField<String> {
        private ComboBox<String> countryCode = new ComboBox<>();
        private TextField number = new TextField();

        public PhoneNumberField(String label) {
            setLabel(label);
            countryCode.setWidth("120px");
            countryCode.setPlaceholder("Country");
            countryCode.setPattern("\\+\\d*");
            countryCode.setPreventInvalidInput(true);
            countryCode.setItems("+354", "+91", "+62", "+98", "+964", "+353", "+44", "+972", "+39", "+225");
            countryCode.addCustomValueSetListener(e -> countryCode.setValue(e.getDetail()));
            number.setPattern("\\d*");
            number.setPreventInvalidInput(true);
            HorizontalLayout layout = new HorizontalLayout(countryCode, number);
            layout.setFlexGrow(1.0, number);
            add(layout);
        }

        @Override
        protected String generateModelValue() {
            if (countryCode.getValue() != null && number.getValue() != null) {
                String s = countryCode.getValue() + " " + number.getValue();
                return s;
            }
            return "";
        }

        @Override
        protected void setPresentationValue(String phoneNumber) {
            String[] parts = phoneNumber != null ? phoneNumber.split(" ", 2) : new String[0];
            if (parts.length == 1) {
                countryCode.clear();
                number.setValue(parts[0]);
            } else if (parts.length == 2) {
                countryCode.setValue(parts[0]);
                number.setValue(parts[1]);
            } else {
                countryCode.clear();
                number.clear();
            }
        }
    }

}

package ch.sascha.tbz.views;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.data.entity.Employment;
import ch.sascha.tbz.data.entity.Person;
import ch.sascha.tbz.data.service.EmploymentService;
import ch.sascha.tbz.data.service.PersonService;
import ch.sascha.tbz.departments.*;
import ch.sascha.tbz.factories.DepartmentFactory;
import ch.sascha.tbz.managers.DepartmentManager;
import ch.sascha.tbz.managers.StaffManager;
import ch.sascha.tbz.pojo.StaffMember;
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
import org.vaadin.artur.helpers.CrudServiceDataProvider;

import java.util.List;
import java.util.stream.Collectors;

@PageTitle("Staff Form")
@Route(value = "staff-form", layout = MainLayout.class)
@Uses(Icon.class)
public class StaffFormView extends Div {

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private EmailField email = new EmailField("Email address");
    private DatePicker dateOfBirth = new DatePicker("Birthday");
    private PhoneNumberField phone = new PhoneNumberField("Phone number");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private Binder<Person> binder = new Binder(Person.class);

    private EmploymentService employmentService;
    private DepartmentManager departmentManager;
    private StaffManager staffManager;

    private Person sampleStaffMember = new StaffMember();

    public StaffFormView(PersonService personService, EmploymentService employmentService) {
        this.employmentService = employmentService;
        departmentManager = new DepartmentManager();
        staffManager = new StaffManager();
        addClassName("staff-form-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());

        save.addClickListener(e -> {
            saveStaffMember();
            personService.update(binder.getBean());
            Notification.show(binder.getBean().getClass().getSimpleName() + " details stored.");
            clearForm();
        });
    }

    private void saveStaffMember(){
        sampleStaffMember = binder.getBean();

        //int departmentWorkerSize = binder.getBean().getDepartment().getEmployeeCount();
        //binder.getBean().getDepartment().setEmployeeCount(departmentWorkerSize++);

        //for(Department department : departmentManager.getDepartments()){
        //    if(department.getClass().equals(sampleStaffMember.getDepartment().getClass())){
        //        department.getEmployees().add((StaffMember) sampleStaffMember);
        //    }
        //}

        staffManager.getAllStaffMembers().add(sampleStaffMember);
        System.out.println(staffManager.getAllStaffMembers().get(0).getFirstName());
    }


    private void clearForm() {
        binder.setBean(new Person());
        sampleStaffMember = null;
    }

    private Component createTitle() {
        return new H3("Personal information");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        email.setErrorMessage("Please enter a valid email address");
        formLayout.add(firstName, lastName, dateOfBirth, createEmploymentDropDownBox(), createDepartmentDropDownBox(), phone, email);
        return formLayout;
    }

    private Component createEmploymentDropDownBox() {
        Select<Employment> employmentStatus = new Select<>();
        employmentStatus.setLabel("Job Title");
        employmentStatus.setItemLabelGenerator(Employment::getEmployment);
        employmentStatus.setItems(employmentService.retrieveAllEmploymentTypes());
        return employmentStatus;
    }

    private Component createDepartmentDropDownBox() {
        Select<Department> departmentDropBox = new Select<>();
        departmentDropBox.setLabel("Active Department");
        departmentDropBox.setItemLabelGenerator(Department::toString);
        departmentDropBox.setItems(
                departmentManager.getDepartmentFactory().getDepartment("a_e"),
                departmentManager.getDepartmentFactory().getDepartment("cardiology"),
                departmentManager.getDepartmentFactory().getDepartment("maternity"),
                departmentManager.getDepartmentFactory().getDepartment("neurology"),
                departmentManager.getDepartmentFactory().getDepartment("operationtheatre"),
                departmentManager.getDepartmentFactory().getDepartment("ophthalmology"),
                departmentManager.getDepartmentFactory().getDepartment("pharmacy"));
        return departmentDropBox;
    }

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

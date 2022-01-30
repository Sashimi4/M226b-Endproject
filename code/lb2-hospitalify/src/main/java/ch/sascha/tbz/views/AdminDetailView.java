package ch.sascha.tbz.views;

import ch.sascha.tbz.data.entity.Person;
import ch.sascha.tbz.data.service.PersonService;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudServiceDataProvider;

/**
 * Admin view page
 */
@PageTitle("Admin Detail")
@Route(value = "admin-detail/:samplePersonID?/:action?(edit)", layout = MainLayout.class)
@Uses(Icon.class)
public class AdminDetailView extends Div implements BeforeEnterObserver {

    private final String SAMPLEPERSON_ID = "samplePersonID";
    private final String SAMPLEPERSON_EDIT_ROUTE_TEMPLATE = "admin-detail/%d/edit";

    /**
     * Grid component
     */
    private Grid<Person> grid = new Grid<>(Person.class, false);

    /**
     * TextField for firstname
     */
    private TextField firstName;
    /**
     * TextField for lastName
     */
    private TextField lastName;
    /**
     * TextField for email
     */
    private TextField email;
    /**
     * TextField for phone
     */
    private TextField phone;
    /**
     * DatePicker for dateOfBirth
     */
    private DatePicker dateOfBirth;

    /**
     * Button for canceling
     */
    private Button cancel = new Button("Cancel");

    /**
     * Button for saving
     */
    private Button save = new Button("Save");

    private BeanValidationBinder<Person> binder;

    private Person samplePerson;

    private PersonService personService;

    /**
     * Constructor for admin detail view page
     * @param personService     Autowired personService object
     */
    public AdminDetailView(@Autowired PersonService personService) {
        this.personService = personService;
        addClassNames("admin-detail-view", "flex", "flex-col", "h-full");
        // Create UI
        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn("firstName").setAutoWidth(true);
        grid.addColumn("lastName").setAutoWidth(true);
        grid.addColumn("email").setAutoWidth(true);
        grid.addColumn("phone").setAutoWidth(true);
        grid.addColumn("dateOfBirth").setAutoWidth(true);

        grid.setDataProvider(new CrudServiceDataProvider<>(personService));
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setHeightFull();

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(SAMPLEPERSON_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(AdminDetailView.class);
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(Person.class);

        // Bind fields. This where you'd define e.g. validation rules

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.samplePerson == null) {
                    this.samplePerson = new Person();
                }
                binder.writeBean(this.samplePerson);

                personService.update(this.samplePerson);
                clearForm();
                refreshGrid();
                Notification.show("Person details stored.");
                UI.getCurrent().navigate(AdminDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the person details.");
            }
        });

    }

    /**
     * Fetch all data before entering
     * @param event     beforeEnterEvent event
     */
    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<Integer> samplePersonId = event.getRouteParameters().getInteger(SAMPLEPERSON_ID);
        if (samplePersonId.isPresent()) {
            Optional<Person> samplePersonFromBackend = personService.get(samplePersonId.get());
            if (samplePersonFromBackend.isPresent()) {
                populateForm(samplePersonFromBackend.get());
            } else {
                Notification.show(
                        String.format("The requested person was not found, ID = %d", samplePersonId.get()), 3000,
                        Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(AdminDetailView.class);
            }
        }
    }

    /**
     * Creates a splitLayout component for the editor view
     * @param splitLayout           SplitLayout component
     */
    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorLayoutDiv = new Div();
        editorLayoutDiv.setClassName("flex flex-col");
        editorLayoutDiv.setWidth("400px");

        Div editorDiv = new Div();
        editorDiv.setClassName("p-l flex-grow");
        editorLayoutDiv.add(editorDiv);

        FormLayout formLayout = new FormLayout();
        firstName = new TextField("First Name");
        lastName = new TextField("Last Name");
        email = new TextField("Email");
        phone = new TextField("Phone");
        dateOfBirth = new DatePicker("Date Of Birth");
        Component[] fields = new Component[]{firstName, lastName, email, phone, dateOfBirth};

        for (Component field : fields) {
            ((HasStyle) field).addClassName("full-width");
        }
        formLayout.add(fields);
        editorDiv.add(formLayout);
        createButtonLayout(editorLayoutDiv);

        splitLayout.addToSecondary(editorLayoutDiv);
    }

    /**
     * Creates layout containing buttons.
     * @return      Custom component
     */
    private void createButtonLayout(Div editorLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setClassName("w-full flex-wrap bg-contrast-5 py-s px-l");
        buttonLayout.setSpacing(true);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);
        editorLayoutDiv.add(buttonLayout);
    }

    /**
     * Creates a grid layout
     * @param splitLayout       SplitLayout component
     */
    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("grid-wrapper");
        wrapper.setWidthFull();
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    /**
     * Refreshes the grid
     */
    private void refreshGrid() {
        grid.select(null);
        grid.getDataProvider().refreshAll();
    }

    /**
     * Clears from and populates the form with a blank Address object
     */
    private void clearForm() {
        populateForm(null);
    }

    /**
     * Populates form
     * @param value     Person object
     */
    private void populateForm(Person value) {
        this.samplePerson = value;
        binder.readBean(this.samplePerson);
    }
}

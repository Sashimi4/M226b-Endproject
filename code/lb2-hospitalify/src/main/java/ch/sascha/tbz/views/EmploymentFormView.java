package ch.sascha.tbz.views;

import ch.sascha.tbz.data.entity.Employment;
import ch.sascha.tbz.data.entity.Person;
import ch.sascha.tbz.data.service.EmploymentService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudServiceDataProvider;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;


// not functioning yet :(


@PageTitle("Employment Form")
@Route(value = "employment-form", layout = MainLayout.class)
@Uses(Icon.class)
public class EmploymentFormView extends Div implements BeforeEnterObserver {

    private final String EMPLOYMENT_ID = "samplePersonID";
    private final TextField enterField = new TextField("Employment type");
    private final Div editorLayoutDiv = new Div();
    private final Grid<Employment> grid = new Grid<>(Employment.class, false);
    private final BeanValidationBinder<Employment> binder;
    private Employment employment;

    private final Button cancel = new Button("Cancel");
    private final Button save = new Button("Save");

    private final EmploymentService employmentService;

    public EmploymentFormView(@Autowired EmploymentService employmentService) {
        this.employmentService = employmentService;

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        createButtonLayout(editorLayoutDiv);
        createGridLayout(splitLayout);

        editorLayoutDiv.add(enterField);

        add(editorLayoutDiv);
        add(splitLayout);


        grid.addColumn("id").setAutoWidth(true);
        grid.addColumn("employment").setAutoWidth(true);
        grid.setDataProvider(new CrudServiceDataProvider<>(employmentService));
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);


        binder = new BeanValidationBinder<>(Employment.class);

        binder.bindInstanceFields(this);


        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.employment == null) {
                    this.employment = new Employment();
                }
                binder.writeBean(this.employment);

                employmentService.update(this.employment);
                clearForm();
                refreshGrid();
                Notification.show("Employment details stored.");
                UI.getCurrent().navigate(AdminDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the employment details.");
            }
        });
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<Integer> employmentId = event.getRouteParameters().getInteger(EMPLOYMENT_ID);
        if (employmentId.isPresent()) {
            Optional<Employment> employmentFromBackend = employmentService.get(employmentId.get());
            if (employmentFromBackend.isPresent()) {
                populateForm(employmentFromBackend.get());
            } else {
                Notification.show(
                        String.format("The requested person was not found, ID = %d", employmentId.get()), 3000,
                        Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(AdminDetailView.class);
            }
        }
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("grid-wrapper");
        wrapper.setWidthFull();
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    private void createButtonLayout(Div editorLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setClassName("w-full flex-wrap bg-contrast-5 py-s px-l");
        buttonLayout.setSpacing(true);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);
        editorLayoutDiv.add(buttonLayout);
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getDataProvider().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(Employment value) {
        this.employment = value;
        binder.readBean(this.employment);
    }
}

package ch.sascha.tbz.views;

import ch.sascha.tbz.data.entity.Address;
import ch.sascha.tbz.data.service.AddressService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * View which holds the Address form
 */
@PageTitle("Address Form")
@Route(value = "address-form", layout = MainLayout.class)
public class AddressFormView extends Div {

    /**
     * TextField for street
     */
    private TextField street = new TextField("Street address");

    /**
     * TextField for postalCode
     */
    private TextField postalCode = new TextField("Postal code");

    /**
     * TextField for city
     */
    private TextField city = new TextField("City");

    /**
     * Dropdown box for all countries
     */
    private ComboBox<String> country = new ComboBox<>("Country");

    /**
     * Button for canceling
     */
    private Button cancel = new Button("Cancel");

    /**
     * Button for saving
     */
    private Button save = new Button("Save");

    /**
     * Binder object for binding values to an object
     */
    private Binder<Address> binder = new Binder<>(Address.class);

    /**
     * Creates the address form web page
     * @param addressService        Autowired address service object
     */
    public AddressFormView(AddressService addressService) {
        addClassName("address-form-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);

        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            addressService.update(binder.getBean());
            Notification.show(binder.getBean().getClass().getSimpleName() + " stored.");
            clearForm();
        });
    }

    /**
     * Creates a new Title object
     * @return      Custom component
     */
    private Component createTitle() {
        return new H3("Address");
    }

    /**
     * Creates Form element containing all text fields and drop boxes
     * @return      Custom component
     */
    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(street, 2);
        postalCode.setPattern("\\d*");
        postalCode.setPreventInvalidInput(true);
        country.setItems("Afghanistan","Albania","Algeria","Andorra","Angola","Antigua & Deps","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","China","Colombia","Comoros","Congo","Congo {Democratic Rep}","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","East Timor","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland {Republic}","Israel","Italy","Ivory Coast","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Korea North","Korea South","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar, {Burma}","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Romania","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia","Saint Vincent & the Grenadines","Samoa","San Marino","Sao Tome & Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe");
        formLayout.add(postalCode, city, country);
        return formLayout;
    }

    /**
     * Creates layout containing buttons.
     * @return      Custom component
     */
    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    /**
     * Clears from and populates the form with a blank Address object
     */
    private void clearForm() {
        this.binder.setBean(new Address());
    }
}

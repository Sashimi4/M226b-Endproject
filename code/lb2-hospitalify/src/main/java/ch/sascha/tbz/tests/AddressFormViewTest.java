package ch.sascha.tbz.tests;

import ch.sascha.tbz.data.entity.Address;
import ch.sascha.tbz.data.service.AddressService;
import ch.sascha.tbz.views.AddressFormView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressFormViewTest {
    private Address validAddress;
    private AddressService addressService;

    @Before
    public void setupData(){
        validAddress = new Address();
        validAddress.setCity("Metropolis");
        validAddress.setStreet("Apple Bottom street 78");
        validAddress.setPostalCode("56473");
    }

    @Test
    public void formFieldsPopulated(){
        AddressFormView form = new AddressFormView(addressService);
        form.setAddressMember(validAddress);
        Assert.assertEquals("Metropolis", form.getBinder().getBean().getCity());
        Assert.assertEquals("Apple Bottom street 78", form.getBinder().getBean().getStreet());
        Assert.assertEquals("56473", form.getBinder().getBean().getPostalCode());
    }

    @Test
    public void formFieldsPopulatedFalse(){
        AddressFormView form = new AddressFormView(addressService);
        form.setAddressMember(validAddress);
        Assert.assertNotEquals("Metro", form.getBinder().getBean().getCity());
        Assert.assertNotEquals("South Side drive", form.getBinder().getBean().getStreet());
        Assert.assertNotEquals("2", form.getBinder().getBean().getPostalCode());
    }
}

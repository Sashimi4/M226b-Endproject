package ch.sascha.tbz.tests;

import ch.sascha.tbz.data.entity.Person;
import ch.sascha.tbz.data.service.EmploymentService;
import ch.sascha.tbz.data.service.PersonService;
import ch.sascha.tbz.views.StaffFormView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class StaffFormViewTest {
    private Person validPerson;

    private PersonService personService;
    private EmploymentService employmentService;

    @Before
    public void setupData(){
        validPerson = new Person();
        validPerson.setFirstName("Jimmy");
        validPerson.setLastName("Berthamolow");
        validPerson.setEmail("marc@usher.com");
    }

    @Test
    public void formFieldsPopulated(){
        StaffFormView form = new StaffFormView(personService, employmentService);
        form.setStaffMember(validPerson);
        Assert.assertEquals("Jimmy", form.getBinder().getBean().getFirstName());
        Assert.assertEquals("Berthamolow", form.getBinder().getBean().getLastName());
        Assert.assertEquals("marc@usher.com", form.getBinder().getBean().getEmail());
    }

    @Test
    public void formFieldsPopulatedFalse(){
        StaffFormView form = new StaffFormView(personService, employmentService);
        form.setStaffMember(validPerson);
        Assert.assertNotEquals("Kimi", form.getBinder().getBean().getFirstName());
        Assert.assertNotEquals("Samuel", form.getBinder().getBean().getLastName());
        Assert.assertNotEquals("ki.sam@gmail.com", form.getBinder().getBean().getEmail());
    }
}
package ch.sascha.tbz.data.service;

import ch.sascha.tbz.data.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

/**
 * Service object for Person entities. Extended by CRUD services and contains the Person repository and actual access to the database through the repository and hibernate.
 */
@Service
public class PersonService extends CrudService<Person, Integer> {

    /**
     * Person repository attribute
     */
    private PersonRepository repository;

    /**
     * Constructor for binding repository to this instance
     * @param repository        Autowired Person repository
     */
    public PersonService(@Autowired PersonRepository repository) {
        this.repository = repository;
    }

    /**
     * Getter method to fetch Person repository
     * @return      PersonRepository object
     */
    @Override
    public PersonRepository getRepository() {
        return repository;
    }
}

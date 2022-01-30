package ch.sascha.tbz.data.service;

import ch.sascha.tbz.data.entity.Employment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import java.util.List;

/**
 * Service object for Employment entities. Extended by CRUD services and contains the Employment repository and actual access to the database through the repository and hibernate.
 */
@Service
public class EmploymentService extends CrudService<Employment, Integer> {

    /**
     * Employment repository attribute
     */
    private EmploymentRepository repository;

    /**
     * Constructor for binding repository to this instance.
     * @param repository        Autowired Employment repository
     */
    public EmploymentService(@Autowired EmploymentRepository repository) {this.repository = repository;}

    /**
     * Getter method to fetch Employment repository
     * @return      EmploymentRepository object
     */
    @Override
    protected EmploymentRepository getRepository() {
        return repository;
    }

    /**
     * Retrieves all entries from the Employment entity table.
     * @return      List of employments
     */
    public List<Employment> retrieveAllEmploymentTypes () {
        return getRepository().findAll();
    }
}

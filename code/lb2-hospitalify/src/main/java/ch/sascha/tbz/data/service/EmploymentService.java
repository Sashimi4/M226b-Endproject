package ch.sascha.tbz.data.service;

import ch.sascha.tbz.data.entity.Employment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import java.util.List;

@Service
public class EmploymentService extends CrudService<Employment, Integer> {

    private EmploymentRepository repository;

    public EmploymentService(@Autowired EmploymentRepository repository) {this.repository = repository;}

    @Override
    protected EmploymentRepository getRepository() {
        return repository;
    }



    /**
     *
     * @return
     */
    public List<Employment> retrieveAllEmploymentTypes () {
        return getRepository().findAll();
    }
}

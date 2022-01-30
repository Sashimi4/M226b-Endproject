package ch.sascha.tbz.data.service;

import ch.sascha.tbz.data.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

/**
 * Service object for Address entities. Extended by CRUD services and contains the Address repository and actual access to the database through the repository and hibernate.
 */
@Service
public class AddressService extends CrudService<Address, Integer> {

    /**
     * Address repository attribute
     */
    private AddressRepository repository;

    /**
     * Constructor for binding repository to this instance.
     * @param repository        Autowired Address repository
     */
    public AddressService(@Autowired AddressRepository repository) {
        this.repository = repository;
    }

    /**
     * Getter method to fetch Address repository
     * @return      AddressRepository object
     */
    @Override
    protected AddressRepository getRepository() {
        return repository;
    }
}

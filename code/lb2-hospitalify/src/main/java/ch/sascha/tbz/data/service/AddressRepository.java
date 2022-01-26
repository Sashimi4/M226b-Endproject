package ch.sascha.tbz.data.service;

import ch.sascha.tbz.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
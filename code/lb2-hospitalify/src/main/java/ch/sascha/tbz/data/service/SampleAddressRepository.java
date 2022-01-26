package ch.sascha.tbz.data.service;

import ch.sascha.tbz.data.entity.SampleAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleAddressRepository extends JpaRepository<SampleAddress, Integer> {

}
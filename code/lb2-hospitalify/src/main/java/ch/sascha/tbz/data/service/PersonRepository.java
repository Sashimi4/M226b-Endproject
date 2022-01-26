package ch.sascha.tbz.data.service;

import ch.sascha.tbz.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
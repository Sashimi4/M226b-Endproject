package ch.sascha.tbz.data.service;

import ch.sascha.tbz.data.entity.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for retrieving Address entities extending from JPA repository
 */
public interface EmploymentRepository extends JpaRepository<Employment, Integer> {
}

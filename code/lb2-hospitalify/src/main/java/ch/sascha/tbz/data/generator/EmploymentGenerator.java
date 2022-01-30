package ch.sascha.tbz.data.generator;

import ch.sascha.tbz.data.entity.Employment;
import ch.sascha.tbz.data.service.EmploymentRepository;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

/**
 * Class which generates data of a specific objects
 */
@SpringComponent
public class EmploymentGenerator {

    /**
     * Method generates data of type Employment and saves them into the table
     * @param employmentRepository      EmploymentRepository object
     * @return                          CommandLineRunner Object
     */
    @Bean
    public CommandLineRunner loadEmploymentData(EmploymentRepository employmentRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (employmentRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 10 Employment entities...");
            ExampleDataGenerator<Employment> employmentRepositoryGenerator = new ExampleDataGenerator<>(
                    Employment.class, LocalDateTime.of(2022, 1, 26, 0, 0, 0));
            employmentRepositoryGenerator.setData(Employment::setId, DataType.ID);
            employmentRepositoryGenerator.setData(Employment::setEmployment, DataType.OCCUPATION);
            employmentRepository.saveAll(employmentRepositoryGenerator.create(10, seed));

            logger.info("Generated demo data");
        };
    }
}

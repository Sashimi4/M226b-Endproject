package ch.sascha.tbz.data.generator;


import ch.sascha.tbz.data.entity.Employment;
import ch.sascha.tbz.data.entity.Person;
import ch.sascha.tbz.data.service.EmploymentRepository;
import ch.sascha.tbz.data.service.PersonRepository;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringComponent
public class EmploymentGenerator {
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

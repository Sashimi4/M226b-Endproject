package ch.sascha.tbz.data.generator;

import ch.sascha.tbz.data.entity.Person;
import ch.sascha.tbz.data.service.PersonRepository;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 * Class which generates data of a specific objects
 */
@SpringComponent
public class DataGenerator {

    /**
     * Method generates data of type Employment and saves them into the table
     * @param personRepository      PersonRepository object
     * @return                      CommandLineRunner Object
     */
    @Bean
    public CommandLineRunner loadPersonData(PersonRepository personRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (personRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 100 Sample Person entities...");
            ExampleDataGenerator<Person> personRepositoryGenerator = new ExampleDataGenerator<>(
                    Person.class, LocalDateTime.of(2022, 1, 26, 0, 0, 0));
            personRepositoryGenerator.setData(Person::setId, DataType.ID);
            personRepositoryGenerator.setData(Person::setFirstName, DataType.FIRST_NAME);
            personRepositoryGenerator.setData(Person::setLastName, DataType.LAST_NAME);
            personRepositoryGenerator.setData(Person::setEmail, DataType.EMAIL);
            personRepositoryGenerator.setData(Person::setPhone, DataType.PHONE_NUMBER);
            personRepositoryGenerator.setData(Person::setDateOfBirth, DataType.DATE_OF_BIRTH);
            personRepository.saveAll(personRepositoryGenerator.create(100, seed));

            logger.info("Generated demo data");
        };
    }
}
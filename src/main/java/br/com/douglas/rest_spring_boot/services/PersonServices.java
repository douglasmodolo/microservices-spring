package br.com.douglas.rest_spring_boot.services;

import br.com.douglas.rest_spring_boot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id)
    {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Douglas");
        person.setLastName("Módolo");
        person.setAddress("Rua 1, Bairro 2");
        person.setGender("Masculino");

        return person;
    }

    public List<Person> findAll()
    {
        logger.info("Finding all Persons!");

        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++)
        {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person create(Person person)
    {
        logger.info("Creating one Person!");

        return person;
    }

    public Person update(String id, Person person)
    {
        logger.info("Updating Person!");

        return person;
    }

    public void delete(String id)
    {
        logger.info("Deleting a Person!");
    }

    private Person mockPerson(int i)
    {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Pessoa");
        person.setLastName(String.valueOf(i));
        person.setAddress("Rua, Numero " + i);
        person.setGender("Masculino");

        return person;
    }

}

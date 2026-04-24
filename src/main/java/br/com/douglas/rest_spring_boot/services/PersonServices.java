package br.com.douglas.rest_spring_boot.services;

import br.com.douglas.rest_spring_boot.exception.ResourceNotFoundException;
import br.com.douglas.rest_spring_boot.model.Person;
import br.com.douglas.rest_spring_boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id)
    {
        logger.info("Finding one Person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
    }

    public List<Person> findAll()
    {
        logger.info("Finding all Persons!");

        return repository.findAll();
    }

    public Person create(Person person)
    {
        logger.info("Creating one Person!");

        return repository.save(person);
    }

    public Person update(Long id, Person person)
    {
        logger.info("Updating Person!");

        if (!id.equals(person.getId()))
            throw new ResourceNotFoundException("No records found for this ID.");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id)
    {
        logger.info("Deleting a Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));

        repository.deleteById(entity.getId());
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

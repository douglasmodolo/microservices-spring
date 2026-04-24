package br.com.douglas.rest_spring_boot.controllers;

import br.com.douglas.rest_spring_boot.model.Person;
import br.com.douglas.rest_spring_boot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices service;
    //private PersonServices service = new PersonServices();

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person finById(@PathVariable("id") Long id)
    {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll()
    {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create(@RequestBody Person person)
    {
        return service.create(person);
    }

    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@PathVariable("id") Long id, @RequestBody Person person)
    {
        return service.update(id, person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

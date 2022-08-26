package com.amrut.prabhu.controller;

import com.amrut.prabhu.model.Person;
import com.amrut.prabhu.model.PersonRepository;
import com.amrut.prabhu.model.PrimaryKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class WebController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/person/{id}")
    public ResponseEntity getPerson(@PathVariable("id") String id,
                                    @RequestParam(value = "creationDate", required = false)
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate creationDate) {

        if (creationDate == null) {
            List<Person> people = personRepository.findById(id);
            return ResponseEntity.ok(people);
        }

        return getByPrimaryKey(id, creationDate);
    }

    @PostMapping("/person")
    public ResponseEntity addPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }

    private ResponseEntity<?> getByPrimaryKey(String id, LocalDate creationDate) {
        PrimaryKey primaryKey = new PrimaryKey();
        primaryKey.setId(id);
        primaryKey.setCreationDate(creationDate);

        Optional<Person> mayBePerson = personRepository.findById(primaryKey);

        if (mayBePerson.isPresent()) {
            return ResponseEntity.ok(mayBePerson.get());
        }
        return ResponseEntity.notFound()
                .build();
    }
}

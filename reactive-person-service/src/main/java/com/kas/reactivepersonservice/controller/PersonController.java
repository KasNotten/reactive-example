package com.kas.reactivepersonservice.controller;

import com.kas.reactivepersonservice.model.Person;
import com.kas.reactivepersonservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public Flux<Person> getAllPersons() {
        return personService.findAll();
    }

    @PostMapping
    public Mono<Person> createPerson(@RequestBody final Person person) {
        return personService.insert(person);
    }
}

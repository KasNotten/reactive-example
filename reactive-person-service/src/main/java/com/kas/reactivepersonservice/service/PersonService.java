package com.kas.reactivepersonservice.service;

import com.kas.reactivepersonservice.model.Person;
import com.kas.reactivepersonservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Flux<Person> findAll() {
        return personRepository.findAll();
    }

    public Mono<Person> insert(final Person person) {
        return personRepository.insert(person);
    }
}

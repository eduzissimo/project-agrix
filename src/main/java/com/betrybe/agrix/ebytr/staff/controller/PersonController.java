package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.PersonCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing persons.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Creates a person.
   */
  @PostMapping
  public HttpEntity<PersonDto> createPerson(@RequestBody PersonCreationDto personCreateDto) {
    Person person = new Person();
    person.setUsername(personCreateDto.username());
    person.setPassword(personCreateDto.password());
    person.setRole(personCreateDto.role());

    Person personCreate = personService.create(person);

    PersonDto personDto = PersonDto.fromEntity(personCreate);

    return ResponseEntity.status(HttpStatus.CREATED).body(personDto);

  }

}

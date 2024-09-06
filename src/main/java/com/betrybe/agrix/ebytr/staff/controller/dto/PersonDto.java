package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;

/**
 * Represents a person and its properties.
 */
public record PersonDto(Long id, String username, String role) {

  /**
   * Converts a person entity to a person DTO.
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getRole().name()
    );
  }

}

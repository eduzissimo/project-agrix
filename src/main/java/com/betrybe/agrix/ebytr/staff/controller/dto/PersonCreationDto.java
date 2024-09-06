package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Represents a person creation DTO.
 */
public record PersonCreationDto(String username, String password, Role role) {}

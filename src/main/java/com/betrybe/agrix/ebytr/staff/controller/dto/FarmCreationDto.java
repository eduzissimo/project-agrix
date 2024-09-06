package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * Represents a farm creation DTO.
 */
public record FarmCreationDto(String name, double size) {

  public Farm toEntity() {
    return new Farm(name, size);
  }
}

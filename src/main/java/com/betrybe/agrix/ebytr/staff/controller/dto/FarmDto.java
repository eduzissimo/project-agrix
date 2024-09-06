package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * Represents a farm and its properties.
 */
public record FarmDto(Long id, String name, double size) {

  /**
   * Converts a farm entity to a farm DTO.
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
      farm.getId(),
      farm.getName(),
      farm.getSize()
    );
  }
}

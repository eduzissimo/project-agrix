package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * DTO for crops.
 */
public record CropDto(Long id, String name, Double plantedArea, LocalDate plantedDate,
                      LocalDate harvestDate, Long farmId) {
  /**
   * Creates a CropDto from a Crop entity.
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getPlantedDate(),
        crop.getHarvestDate(),
        crop.getFarm().getId()
    );
  }
}

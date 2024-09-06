package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * DTO for creating a crop.
 */
public record CropCreationDto(Long id, String name, Double plantedArea, LocalDate plantedDate,
                              LocalDate harvestDate, Long farmId) {

  /**
   * Converts CropCreationDto to Crop entity.
   */
  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setName(name());
    crop.setPlantedArea(plantedArea());
    crop.setPlantedDate(plantedDate());
    crop.setHarvestDate(harvestDate());
    return crop;
  }

  /**
   * Creates a CropCreationDto from a Crop entity.
   */
  public static CropCreationDto fromEntity(Crop crop) {
    return new CropCreationDto(crop.getId(), crop.getName(), crop.getPlantedArea(),
        crop.getPlantedDate(), crop.getHarvestDate(), crop.getFarm().getId());
  }
}

package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing crops.
 */
@RestController
@RequestMapping("/crops")
public class CropsController {

  private final CropService cropService;

  public CropsController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Returns a list of all crops.
   */
  @GetMapping
  public List<CropDto> getCrops() throws CropNotFoundException {
    List<Crop> crops = cropService.getAllCrops();
    return crops.stream()
        .map(CropDto::fromEntity)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public CropDto getCropById(@PathVariable Long id) throws CropNotFoundException {
    Crop crop = cropService.getCropById(id);
    return CropDto.fromEntity(crop);
  }

  /**
   * Search crops by harvest date.
   */
  @GetMapping("/search")
  public List<CropDto> searchCropsByHarvestDate(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end) {
    List<Crop> crops = cropService.findCropsByHarvestDateRange(start, end);
    return crops.stream()
        .map(CropDto::fromEntity)
        .collect(Collectors.toList());
  }

  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String associateFertilizerWithCrop(
      @PathVariable Long cropId,
      @PathVariable Long fertilizerId
  )
      throws CropNotFoundException {
    cropService.associateFertilizerWithCrop(cropId, fertilizerId);
    return "Fertilizante e plantação associados com sucesso!";
  }

  /**
   * List fertilizers by crop.
   */
  @GetMapping("/{cropId}/fertilizers")
  public List<FertilizerDto> listFertilizersByCrop(
      @PathVariable Long cropId
  ) throws CropNotFoundException {
    return cropService.listFertilziersByCropId(cropId).stream()
        .map(FertilizerDto::fromEntity)
        .collect(Collectors.toList());
  }
}

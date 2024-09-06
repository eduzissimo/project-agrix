package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FarmCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing farms.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {
  private final FarmService farmService;

  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    return FarmDto.fromEntity(farmService.saveFarm(farmCreationDto.toEntity()));
  }

  /**
   * Returns a list of all farms.
   */
  @GetMapping
  public List<FarmDto> getFarms() {
    return farmService.getAllFarms().stream()
        .map(FarmDto::fromEntity)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public FarmDto getFarmById(@PathVariable Long id) throws FarmNotFoundException {
    return FarmDto.fromEntity(farmService.getFarmById(id));
  }

  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCrop(@PathVariable Long farmId, @RequestBody CropCreationDto cropCreationDto)
      throws FarmNotFoundException {
    return CropDto.fromEntity(farmService.createCrop(farmId, cropCreationDto.toEntity()));
  }

  /**
   * Returns a list of crops for a farm.
   */
  @GetMapping("/{farmId}/crops")
  public List<CropDto> getCropsByFarmId(@PathVariable Long farmId) throws FarmNotFoundException {
    return farmService.getCropsByFarmId(farmId).stream()
        .map(CropDto::fromEntity)
        .collect(Collectors.toList());
  }
}
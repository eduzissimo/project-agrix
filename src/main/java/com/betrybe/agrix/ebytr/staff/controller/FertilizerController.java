package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
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
 * Service responsible for managing fertilizers.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto createFertilizer(@RequestBody FertilizerCreationDto fertilizerCreationDto) {
    Fertilizer fertilizer = fertilizerService.createFertilizer(fertilizerCreationDto.toEntity());
    return FertilizerDto.fromEntity(fertilizer);
  }

  /**
   * Lists all fertilizers.
   */
  @GetMapping
  public List<FertilizerDto> listFertilizers() {
    return fertilizerService.listFertilizers().stream()
        .map(FertilizerDto::fromEntity)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public FertilizerDto getFertilizer(@PathVariable Long id) {
    return FertilizerDto.fromEntity(fertilizerService.getFertilizer(id));
  }
}

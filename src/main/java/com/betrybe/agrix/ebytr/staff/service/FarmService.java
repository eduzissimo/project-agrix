package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service responsible for managing farms.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  public Farm saveFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  public Farm getFarmById(Long id) throws FarmNotFoundException {
    return farmRepository.findById(id)
        .orElseThrow(FarmNotFoundException::new);
  }

  /**
   * Creates a crop for a farm.
   */
  public Crop createCrop(Long farmId, Crop crop) throws FarmNotFoundException {
    Farm farm = getFarmById(farmId);

    crop.setFarm(farm);

    return cropRepository.save(crop);
  }

  public List<Crop> getCropsByFarmId(Long farmId) throws FarmNotFoundException {
    Farm farm = getFarmById(farmId);
    return cropRepository.findByFarm(farm);
  }

}

package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for managing crops.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public CropService(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
    this.cropRepository = cropRepository;
    this.fertilizerRepository = fertilizerRepository;
  }
  /**
   * Returns a list of all crops.
   */

  public List<Crop> getAllCrops() {
    return cropRepository.findAll();
  }

  public Crop getCropById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id)
        .orElseThrow(() -> new CropNotFoundException("Plantação não encontrada!"));
  }

  public List<Crop> findCropsByHarvestDateRange(LocalDate start, LocalDate end) {
    return cropRepository.findByHarvestDateBetween(start, end);
  }

  /**
   * Associates a fertilizer with a crop.
   */
  @Transactional
  public void associateFertilizerWithCrop(
      Long cropId,
      Long fertilizerId
  ) throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = cropRepository.findById(cropId)
        .orElseThrow(() -> new CropNotFoundException("Plantação não encontrada!"));
    Fertilizer fertilizer = fertilizerRepository.findById(fertilizerId)
        .orElseThrow(() -> new FertilizerNotFoundException("Fertilizante não encontrado!"));

    crop.addFertilizer(fertilizer);
    cropRepository.save(crop);
  }

  /**
   * Lists all fertilizers associated with a crop.
   */
  public List<Fertilizer> listFertilziersByCropId(Long cropId) throws CropNotFoundException {
    Crop crop = cropRepository.findById(cropId)
        .orElseThrow(() -> new CropNotFoundException("Plantação não encontrada!"));
    return crop.getFertilizers();
  }
}

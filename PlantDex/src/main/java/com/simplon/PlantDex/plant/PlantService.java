package com.simplon.PlantDex.plant;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService {
    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<PlantDto> findAll() {
        return plantRepository.findAll().stream()
                .map(PlantDto::fromBookEntity)
                .collect(Collectors.toList());
    }

    public PlantDto findById(Long id) {
        return PlantDto.fromBookEntity(plantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No book was found with the provided ID : " + id)));
    }

    public Long save(PlantDto plantDto) {
        PlantEntity plant = PlantDto.toBookEntity(plantDto);
        return plantRepository.save(plant).getId();
    }
    public PlantEntity update(PlantDto plantDto,Long plantid) {
        PlantEntity pantToUpdate=plantRepository.findById(plantid).get();
      PlantDto plantToUpdateDto =PlantDto.fromBookEntity(pantToUpdate);

      plantToUpdateDto.setArrosage(plantDto.getArrosage());
      plantToUpdateDto.setNom(plantDto.getNom());
      plantToUpdateDto.setCategorie(plantDto.getCategorie());
      plantToUpdateDto.setSoleil(plantDto.getSoleil());
      plantToUpdateDto.setImage(plantDto.getImage());

        PlantEntity plant = PlantDto.toBookEntity(plantToUpdateDto);
        return plantRepository.save(plant);
    }

    public void delete(Long id) {
        plantRepository.deleteById(id);
    }
}

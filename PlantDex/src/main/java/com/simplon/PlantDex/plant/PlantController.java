package com.simplon.PlantDex.plant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {
    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllPlants")
    public ResponseEntity<List<PlantDto>> getAll() {

        return ResponseEntity.ok(plantService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getPlantById")
    public ResponseEntity<PlantDto> findById(
            @RequestParam("plant-id") Long bookId
    ) {

        return ResponseEntity.ok(plantService.findById(bookId));
    }

    @PostMapping("/createPlant")
    public ResponseEntity<Long> save(@RequestBody PlantDto plantDto) {
        return ResponseEntity.ok(plantService.save(plantDto));
    }

    @DeleteMapping("/deletePlantId")
    public ResponseEntity<Void> delete(
            @RequestParam("plant-id") Long code
    ) {
        plantService.delete(code);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/updatePlant/{plant-id}")
    public ResponseEntity<PlantEntity> update(
            @RequestBody PlantDto plantDto,@PathVariable("plant-id") Long plantid
    ) {

        return ResponseEntity.ok(plantService.update(plantDto,plantid));

    }
}

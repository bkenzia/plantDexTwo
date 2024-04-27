package com.simplon.PlantDex.plant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlantDto {

    private Long id;

    private String nom;

    private String soleil;

    private Long arrosage;

    private String categorie;

    private String image;


    public static PlantDto fromBookEntity(PlantEntity plant) {
        return PlantDto.builder()
                .id(plant.getId())
                .nom(plant.getNom())
                .soleil(plant.getSoleil())
                .arrosage(plant.getArrosage())
                .categorie(plant.getCategorie())
                .image(plant.getImage())
                .build();
    }


    public static PlantEntity toBookEntity(PlantDto plant) {
        return PlantEntity.builder()
                .id(plant.getId())
                .nom(plant.getNom())
                .soleil(plant.getSoleil())
                .arrosage(plant.getArrosage())
                .categorie(plant.getCategorie())
                .image(plant.getImage())
                .build();
    }

}

import {Component, Input} from '@angular/core';
import {PlantService} from "../../services/plant.service";
import {Subscription} from "rxjs";
import {Plant} from "../../models/plant";

@Component({
  selector: 'app-page-my-plants',
  templateUrl: './page-my-plants.component.html',
  styleUrls: ['./page-my-plants.component.css']
})
export class PageMyPlantsComponent {


  plantsToDisplay!: Plant[];
  constructor(private instancePlantService: PlantService) {}
  ngOnInit() {
    this.instancePlantService.getPlants().subscribe((data: Plant[]) => {
      console.log(data);

      this.plantsToDisplay = [...data];

      // Pour supprimer les doublons d'un tableau
      // [...new Set(tableau)]

    });
  }




}

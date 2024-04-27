import {HttpClient, HttpHeaders,HttpParams} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Plant } from '../models/plant';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PlantService {
  constructor(private http: HttpClient) {}

  /**
   * La méthode getPlants retourne
   * une requête http de type GET (on veut récupérer de données)
   * dont les données seront de type Plant[] (tableau d'objets de type Plant)
   * à partir de l'URL "http://localhost:3000/plants"
   *
   */
  getPlants(): Observable<Plant[]> {
    return this.http.get<Plant[]>('http://localhost:3000/plants/getAllPlants');
  }
  getPlantsById(params: {
    'plant-id'?: number;
  }): Observable<Plant> {
    const httpOptions = {
      headers: new HttpHeaders(),
      params: ((params != null) ? params : new HttpParams())
    };
    return this.http.get<Plant>('http://localhost:3000/plants/getPlantById',httpOptions);
  }


}

import {Component, OnInit} from '@angular/core';
import {AnimalResource} from "../resource/animal-resource";
import {Animal} from "../../commons/models/animal";
import {Router} from "@angular/router";

@Component({
  selector: 'app-animal-list',
  templateUrl: './animal-list.component.html',
  styleUrls: ['./animal-list.component.css']
})
export class AnimalListComponent implements OnInit {

  animals: Animal[];
  loadAnimals = true;

  constructor(private animalResource: AnimalResource, private router: Router) {
  }

  ngOnInit() {
    this.animalResource.get().subscribe(
      value => {
        this.animals = value;
        this.loadAnimals = false;
      });
    ;
  }

  viewAnimal(animal: Animal) {
    console.log(animal);
    this.animalResource.animal = animal;
    // this.router.navigateByUrl('animal')
  }

}

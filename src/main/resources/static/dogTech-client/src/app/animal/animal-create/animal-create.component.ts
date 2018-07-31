import { Component, OnInit } from '@angular/core';
import { Animal } from '../../commons/models/animal';
import { AnimalResource } from '../resource/animal-resource';
import { MenuItem, SelectItem } from 'primeng/api';

@Component({
  selector: 'app-animal-create',
  templateUrl: './animal-create.component.html',
  styleUrls: ['./animal-create.component.css']
})
export class AnimalCreateComponent implements OnInit {

  animal: Animal;
  specie = true;
  sex = true;
  breeds: any[];
  sizes: SelectItem[];
  temperaments: SelectItem[];

  stepsToForm: MenuItem[];
  activeIndex = 0;

  constructor(private animalResource: AnimalResource) {
    this.sizes = [
      { label: 'Pequeno', value: 'small' },
      { label: 'Médio', value: 'medium' },
      { label: 'Grande', value: 'big' }
    ];
    this.temperaments = [
      { label: 'Dócil', value: 'DOCILE' },
      { label: 'Agressivo', value: 'AGGRESSIVE' },
      { label: 'Bipolar', value: 'BIPOLAR' },
      { label: 'Não sociavel', value: 'NOT_SOCIABLE' },
      { label: 'Temperamental', value: 'TEMPERAMENTAL' },
      { label: 'Arisco', value: 'ARISCO' }
    ];
  }

  ngOnInit() {
    if (this.animalResource.animal == null) {
      this.animal = new Animal();
      this.animal.castred = false;
      this.animal.dewormed = true;
    }
  }

  handleSpecie(e) {
    if (this.specie) {
      this.animal.species = 'CANINE';
    } else {
      this.animal.species = 'FELINE';
    }
  }

  handleSex(e) {
    if (this.sex) {
      this.animal.species = 'MALE';
    } else {
      this.animal.species = 'FEMALE';
    }
  }

  private createStepMenu() {
    console.log(this.animal.approximateAge);
  }

}

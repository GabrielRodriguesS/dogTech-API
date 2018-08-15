import { Component, OnInit } from '@angular/core';
import { Animal } from '../../commons/models/animal';
import { AnimalResource } from '../resource/animal-resource';
import { Baia } from '../../commons/models/baia';

@Component({
  selector: 'app-animal-create',
  templateUrl: './animal-create.component.html',
  styleUrls: ['./animal-create.component.css']
})
export class AnimalCreateComponent implements OnInit {

  animal: Animal;
  breeds: any[];
  baias: Baia[];
  temperaments: any[];

  stringToCastred: string;
  stringToDewormed: string;
  stringToPatrimonioTombado: string;
  stringToCare: string;
  stringToAvailable: string;
  visible = false;

  current = 2;


  constructor(private animalResource: AnimalResource) {
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
    }
  }

  handleBoolean(event, attribute: string): void {
    if (event === 'no') {
      this.animal[attribute] = false;
    } else {
      this.animal[attribute] = true;
    }
  }
  // todo criar um animalAvailableValidator para fazer valer a regra de negócio
  pre(): void {
    this.current -= 1;
  }

  next(): void {
    this.current += 1;
  }

  done(): void {
    console.log('done');
  }

  open(): void {
    this.visible = true;
  }

  close(): void {
    this.visible = false;
  }

}

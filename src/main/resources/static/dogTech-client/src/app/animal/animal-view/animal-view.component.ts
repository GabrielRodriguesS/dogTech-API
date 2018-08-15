import {Component, Input, OnInit} from '@angular/core';
import {Animal} from '../../commons/models/animal';
import {AnimalResource} from '../resource/animal-resource';

@Component({
  selector: 'app-animal-view',
  templateUrl: './animal-view.component.html',
  styleUrls: ['./animal-view.component.css']
})
export class AnimalViewComponent implements OnInit {

  @Input()
  animal: Animal;

  constructor(private animalResource: AnimalResource) { }

  ngOnInit() {
    this.animal = this.animalResource.animal;
  }

}

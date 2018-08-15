import {Injectable} from '@angular/core';
import {AbstractResource} from '../../core/resource/abstrat-resource';
import {Animal} from '../../commons/models/animal';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class AnimalResource extends AbstractResource<Animal> {

  public animals: Animal[];
  public animal: Animal;

  constructor(httpClient: HttpClient) {
    super(httpClient, 'animals');
  }

  public getAnimals() {
    this.get().subscribe(
      value => {
        return value;
      });
  }
}

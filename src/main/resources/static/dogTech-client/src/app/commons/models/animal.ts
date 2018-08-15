import { Baia } from './baia';

export class Animal {
  id: number;
  name: string;
  history: string;
  available: boolean;
  species: string;
  sex: string;
  castred: boolean;
  dewormed: boolean;
  patrimonioTombado: boolean;
  care: boolean;
  temperament: string[];
  size: string;
  otherInformation: string;
  approximateAge: string;
  breedList: any[];
  photoList: any[];
  listVaccinesAnimalList: any[];
  baia: Baia;

  constructor() {
    this.castred = false;
    this.dewormed = true;
    this.species = 'CANINE';
    this.available = true;
    this.sex = 'MALE';
    this.patrimonioTombado = false;
    this.care = false;
    this.size = 'MEDIUM';
  }
}

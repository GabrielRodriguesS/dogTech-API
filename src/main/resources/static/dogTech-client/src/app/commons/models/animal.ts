import {Baia} from './baia';

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
  temperament: string;
  size: string;
  otherInformation: string;
  approximateAge: string;
  breedList: any[];
  photoList: any[];
  listVaccinesAnimalList: any[];
  baia: Baia;
}

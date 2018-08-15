import { Injectable } from '@angular/core';
import { AbstractResource } from 'src/app/core/resource/abstrat-resource';
import { Baia } from 'src/app/commons/models/baia';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class BaiaResource extends  AbstractResource<Baia> {

    constructor(httpClient: HttpClient) {
        super(httpClient, 'baias');
      }
}

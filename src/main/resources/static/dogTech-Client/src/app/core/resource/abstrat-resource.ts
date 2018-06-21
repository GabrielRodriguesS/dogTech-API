import {environment} from '../../../environments/environment';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

export abstract class AbstractResource<Entity> {
  protected url: string = environment.apiUrl;

  protected constructor(private http: HttpClient, private endPoint: string) {
    if (endPoint) {
      this.url = this.url + '/' + endPoint;
    }
  }

  public get(): Observable<Array<Entity>> {
    return this.http.get<Array<Entity>>(this.url);
  }

  public getWithParameters(parameters: string): Observable<Entity> {
    return this.http.get<Entity>(this.url + '/?' + parameters);
  }

  public post(entity: Entity): Observable<Entity> {
    return this.http.post<Entity>(this.endPoint, entity);
  }

  public put(entity: Entity, id: number): Observable<Entity> {
    return this.http.put<Entity>(this.url + '/' + id, entity);
  }

  public deleteById(id: number): Observable<{}> {
    return this.http.delete(this.url + '/' + id);
  }

  // TODO receber um parametro map, iterar ele e returnar o objeto.
  private getParameters(): HttpParams {
    return new HttpParams()
      .set('a', 'a');
  }
}

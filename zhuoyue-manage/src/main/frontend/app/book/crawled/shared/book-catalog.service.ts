/**
 * Created by lihaitao on 2016/11/14.
 */
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {AuthService} from "../../../shared/auth/auth.service";
import {BookCatalog} from "./book-catalog.model";
import {Observable} from "rxjs";
import 'rxjs/add/operator/toPromise';
import {Pageable} from "../../../shared/utils/pageable.model";

/**
 * 图书目录模块前端数据服务
 */
@Injectable()
export class BookCatalogService {

  constructor(public http: Http, public authService: AuthService) {

  }

  public deleteBookCatalog(bookCatalog: BookCatalog): Promise<void> {
    return this.http.delete(`/crawler/bookCatalog/${bookCatalog.id}`, {headers: this.authService.getAuthorizationHeaders()})
        .toPromise()
        .then(data => console.log('Removed', data.json()))
        .catch(this.handleError);
  }

  public fetchBookCatalogs(pageable: Pageable): Promise<BookCatalog[]> {
    return this.http.get('/crawler/bookCatalogs?'+pageable.toUrlParam(), {headers: this.authService.getAuthorizationHeaders()})
      .toPromise()
      .then(data => data.json())
      .catch(this.handleError);
  }

  public recordBook(itemId: string, site: string){

  }

  public abondonBook(itemId: string, site: string){

  }



  // private handleError (error: Response | any) {
  //   // In a real world app, we might use a remote logging infrastructure
  //   let errMsg: string;
  //   if (error instanceof Response) {
  //     const body = error.json() || '';
  //     const err = body.error || JSON.stringify(body);
  //     errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
  //   } else {
  //     errMsg = error.message ? error.message : error.toString();
  //   }
  //   console.error(errMsg);
  //   return Observable.throw(errMsg);
  // }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}



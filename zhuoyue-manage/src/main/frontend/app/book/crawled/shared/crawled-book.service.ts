/**
 * Created by lihaitao on 2016/11/20.
 */
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {AuthService} from "../../../shared/auth/auth.service";
import {BookCatalog} from "./book-catalog.model";
import {Pageable} from "../../../shared/utils/pageable.model";

/**
 * 图书目录模块前端数据服务
 */
@Injectable()
export class CrawledBookService {

  constructor(public http: Http, public authService: AuthService) {

  }

  public crawlBookDetail(itemId: string) {
  }
}

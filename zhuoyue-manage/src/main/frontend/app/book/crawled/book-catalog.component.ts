/**
 * Created by lihaitao on 2016/11/14.
 */
import {Component, OnInit} from '@angular/core';
import {BookCatalog} from "./shared/book-catalog.model";
import {BookCatalogService} from "./shared/book-catalog.service";
import {Page} from "../../shared/utils/page.model";
import {Pageable} from "../../shared/utils/pageable.model";

@Component({
  selector: 'zhuoyue-crud',
  templateUrl: './book-catalog.component.html',
  styleUrls: ['./book-catalog.component.scss']
})
export class BookCatalogComponent implements OnInit {

  bookCatalogs: BookCatalog[] = [];
  links: any;
  page: Page;
  selection: string[];


  constructor(public bookCatalogService: BookCatalogService) {
  }


  ngOnInit(): any {
    console.log('hello `Crud` component');
    let pageable = new Pageable(0, null, "rank");
    this.fetchBookCatalogs(null, pageable);
  }

  fetchBookCatalogs(url: string, pageable?: Pageable): void {
    this.bookCatalogService
      .fetchBookCatalogs(url, pageable)
      .then(pages=>this.dealPages(pages));
  }

  toPage(pageUrl: string): void {
    // let uri = new URI(pageUrl);
    // let path = uri.relativeTo(uri.origin()).toString();
    // console.log(path);
    this.fetchBookCatalogs(pageUrl);
  }

  dealPages(pages): void {
    this.bookCatalogs = pages._embedded.bookCatalogs;
    this.links = pages._links;
    this.page = pages.page;
  }

  refresh(): void {
    this.fetchBookCatalogs(this.links.self.href);
  }

  searchByIsbn(): void {

  }

}

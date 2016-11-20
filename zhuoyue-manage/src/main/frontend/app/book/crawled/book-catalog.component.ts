/**
 * Created by lihaitao on 2016/11/14.
 */
import {Component, OnInit} from '@angular/core';
import {BookCatalog} from "./shared/book-catalog.model";
import {BookCatalogService} from "./shared/book-catalog.service";
import {Pageable} from "../../shared/utils/pageable.model";

@Component({
  selector: 'zhuoyue-crud',
  templateUrl: './book-catalog.component.html',
  styleUrls: ['./book-catalog.component.scss']
})
export class BookCatalogComponent implements OnInit {

  bookCatalogs: BookCatalog[] = [];
  pageable: Pageable = new Pageable(1);
  selection: string[];

  constructor(public bookCatalogService: BookCatalogService) {
  }


  ngOnInit(): any {
    console.log('hello `Crud` component');
    this.fetchBookCatalogs();
  }

  fetchBookCatalogs(): void {
    this.bookCatalogService
      .fetchBookCatalogs(this.pageable)
      .then(bookCatalogs => this.bookCatalogs = bookCatalogs);
  }

  refresh(): void {
    this.fetchBookCatalogs();
  }


}

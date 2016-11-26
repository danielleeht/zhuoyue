/**
 * Created by lihaitao on 2016/11/14.
 */
import {NgModule} from '@angular/core';
import {BookCatalogComponent} from './crawled/book-catalog.component';
import {BookRoutingModule} from './book-routing.module';
import {BookCatalogService} from './crawled/shared/book-catalog.service';
import {COMMON_CHILD_MODULES} from '../shared/common/common.modules';
import {CommonModule} from '@angular/common';

@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    CommonModule,
    BookRoutingModule
  ],
  providers: [
    BookCatalogService
  ],
  declarations: [BookCatalogComponent]
})
export class BookModule {
}

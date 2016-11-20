/**
 * Created by lihaitao on 2016/11/14.
 */
import {Routes, RouterModule} from '@angular/router';
import {BookCatalogComponent} from './crawled/book-catalog.component';
import {NgModule} from '@angular/core/src/metadata/ng_module';


export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: BookCatalogComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class BookRoutingModule {
}




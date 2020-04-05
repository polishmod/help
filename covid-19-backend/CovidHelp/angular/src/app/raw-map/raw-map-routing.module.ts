import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {RawMapComponent} from "./raw-map/raw-map.component";

const routes: Routes = [{
  path: 'map',
  component: RawMapComponent,
}];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RawMapRoutingModule {
}

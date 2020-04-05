import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {OlMapComponent} from './ol-map/ol-map.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import {FormsModule} from '@angular/forms';
import {DefdevAngularNebularModule, NebularModule} from 'defdev-angular-nebular';


@NgModule({
  declarations: [OlMapComponent, UserDetailsComponent],
  exports: [OlMapComponent, UserDetailsComponent],
  imports: [
    CommonModule,
    CommonModule,
    FormsModule,
    NebularModule,
    DefdevAngularNebularModule,
  ]
})
export class ComponentsModule {
}

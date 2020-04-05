import {Component, OnInit} from '@angular/core';
import {NbIconLibraries} from '@nebular/theme';
import {ConfigService} from 'defdev-angular-nebular';

@Component({
  selector: 'ngx-app',
  template: '<router-outlet></router-outlet>',
})
export class AppComponent implements OnInit {

  constructor(
    private configService: ConfigService,
    private iconLibraries: NbIconLibraries) {
  }

  ngOnInit() {
    this.configService.ngOnInit();
    this.iconLibraries.registerFontPack('nebular', {iconClassPrefix: 'nb'});
    this.iconLibraries.setDefaultPack('nebular');
  }
}

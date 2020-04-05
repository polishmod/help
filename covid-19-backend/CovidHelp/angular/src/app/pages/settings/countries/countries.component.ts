import {Component, OnInit} from '@angular/core';
import {ITableConfig} from "defdev-angular-nebular";
import {ModelTypes} from "../../../generated-api/models";

@Component({
  selector: 'ngx-countries',
  template: `
    <ngx-config-based-table-component [tableConfig]="tableConfig"></ngx-config-based-table-component>`
})
export class CountriesComponent implements OnInit {
  tableConfig: ITableConfig = {
    modelType: ModelTypes.COUNTRY,
    title: 'Countries',
    showBulkUpdate: false,
  }

  constructor() {
  }

  ngOnInit() {
  }

}

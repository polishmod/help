import {Component, OnInit} from '@angular/core';
import {NbTokenService} from '@nebular/auth';

@Component({
  selector: 'ngx-account-settings',
  template: `
    <ngx-user-details [userId]="userId" *ngIf="userId"></ngx-user-details>
  `,
})
export class AccountSettingsComponent implements OnInit {
  userId: number;

  constructor(
    private readonly tokenService: NbTokenService,
  ) {
  }

  ngOnInit() {
    this.tokenService.get().subscribe(token => {
      this.userId = Number(token.getPayload()['sub']);
    });
  }


}

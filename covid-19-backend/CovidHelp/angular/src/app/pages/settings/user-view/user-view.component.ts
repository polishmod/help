import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {withLatestFrom} from 'rxjs/operators';

@Component({
  selector: 'ngx-user-view',
  template: `
    <ngx-user-details [userId]='userId' *ngIf='userId'></ngx-user-details>
  `,
})
export class UserViewComponent implements OnInit {

  userId: number;

  constructor(private readonly router: Router,
              private readonly route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.paramMap.pipe(
      withLatestFrom(this.route.queryParamMap)
    ).subscribe(([params, queryParams]) => {
      let userId = Number(params.get('id'));
      if (!userId) {
        userId = -1;
      }
      this.userId = userId;
    });
  }

}

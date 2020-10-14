import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IDowJonesIndex, DowJonesIndex } from 'app/shared/model/dow-jones-index.model';
import { DowJonesIndexService } from './dow-jones-index.service';
import { DowJonesIndexComponent } from './dow-jones-index.component';
import { DowJonesIndexDetailComponent } from './dow-jones-index-detail.component';

@Injectable({ providedIn: 'root' })
export class DowJonesIndexResolve implements Resolve<IDowJonesIndex> {
  constructor(private service: DowJonesIndexService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IDowJonesIndex> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((dowJonesIndex: HttpResponse<DowJonesIndex>) => {
          if (dowJonesIndex.body) {
            return of(dowJonesIndex.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new DowJonesIndex());
  }
}

export const dowJonesIndexRoute: Routes = [
  {
    path: '',
    component: DowJonesIndexComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'DowJonesIndices',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: DowJonesIndexDetailComponent,
    resolve: {
      dowJonesIndex: DowJonesIndexResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'DowJonesIndices',
    },
    canActivate: [UserRouteAccessService],
  },
];

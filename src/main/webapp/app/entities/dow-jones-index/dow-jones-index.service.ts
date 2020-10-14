import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IDowJonesIndex } from 'app/shared/model/dow-jones-index.model';

type EntityResponseType = HttpResponse<IDowJonesIndex>;
type EntityArrayResponseType = HttpResponse<IDowJonesIndex[]>;

@Injectable({ providedIn: 'root' })
export class DowJonesIndexService {
  public resourceUrl = SERVER_API_URL + 'api/dow-jones-indices';

  constructor(protected http: HttpClient) {}

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IDowJonesIndex>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IDowJonesIndex[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  protected convertDateFromClient(dowJonesIndex: IDowJonesIndex): IDowJonesIndex {
    const copy: IDowJonesIndex = Object.assign({}, dowJonesIndex, {
      date: dowJonesIndex.date && dowJonesIndex.date.isValid() ? dowJonesIndex.date.format(DATE_FORMAT) : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.date = res.body.date ? moment(res.body.date) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((dowJonesIndex: IDowJonesIndex) => {
        dowJonesIndex.date = dowJonesIndex.date ? moment(dowJonesIndex.date) : undefined;
      });
    }
    return res;
  }
}

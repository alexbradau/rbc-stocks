import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { DowJonesIndexService } from 'app/entities/dow-jones-index/dow-jones-index.service';
import { IDowJonesIndex, DowJonesIndex } from 'app/shared/model/dow-jones-index.model';

describe('Service Tests', () => {
  describe('DowJonesIndex Service', () => {
    let injector: TestBed;
    let service: DowJonesIndexService;
    let httpMock: HttpTestingController;
    let elemDefault: IDowJonesIndex;
    let expectedResult: IDowJonesIndex | IDowJonesIndex[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(DowJonesIndexService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new DowJonesIndex(0, 0, 'AAAAAAA', currentDate, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            date: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should return a list of DowJonesIndex', () => {
        const returnedFromService = Object.assign(
          {
            quarter: 1,
            stock: 'BBBBBB',
            date: currentDate.format(DATE_FORMAT),
            open: 1,
            high: 1,
            low: 1,
            close: 1,
            volume: 1,
            percentChangePrice: 1,
            percentChangeVolumeOverLastWeek: 1,
            previousWeeksVolume: 1,
            nextWeeksOpen: 1,
            nextWeeksClose: 1,
            percentChangeNextWeeksPrice: 1,
            daysToNextDividend: 1,
            percentReturnNextDividend: 1,
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            date: currentDate,
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});

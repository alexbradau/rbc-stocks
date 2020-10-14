import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, convertToParamMap } from '@angular/router';

import { RbcstocksTestModule } from '../../../test.module';
import { DowJonesIndexComponent } from 'app/entities/dow-jones-index/dow-jones-index.component';
import { DowJonesIndexService } from 'app/entities/dow-jones-index/dow-jones-index.service';
import { DowJonesIndex } from 'app/shared/model/dow-jones-index.model';

describe('Component Tests', () => {
  describe('DowJonesIndex Management Component', () => {
    let comp: DowJonesIndexComponent;
    let fixture: ComponentFixture<DowJonesIndexComponent>;
    let service: DowJonesIndexService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [RbcstocksTestModule],
        declarations: [DowJonesIndexComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: {
              data: of({
                defaultSort: 'id,asc',
              }),
              queryParamMap: of(
                convertToParamMap({
                  page: '1',
                  size: '1',
                  sort: 'id,desc',
                })
              ),
            },
          },
        ],
      })
        .overrideTemplate(DowJonesIndexComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DowJonesIndexComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DowJonesIndexService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DowJonesIndex(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.dowJonesIndices && comp.dowJonesIndices[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DowJonesIndex(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.dowJonesIndices && comp.dowJonesIndices[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      comp.ngOnInit();
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // INIT
      comp.ngOnInit();

      // GIVEN
      comp.predicate = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { RbcstocksTestModule } from '../../../test.module';
import { DowJonesIndexDetailComponent } from 'app/entities/dow-jones-index/dow-jones-index-detail.component';
import { DowJonesIndex } from 'app/shared/model/dow-jones-index.model';

describe('Component Tests', () => {
  describe('DowJonesIndex Management Detail Component', () => {
    let comp: DowJonesIndexDetailComponent;
    let fixture: ComponentFixture<DowJonesIndexDetailComponent>;
    const route = ({ data: of({ dowJonesIndex: new DowJonesIndex(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [RbcstocksTestModule],
        declarations: [DowJonesIndexDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(DowJonesIndexDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(DowJonesIndexDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load dowJonesIndex on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.dowJonesIndex).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});

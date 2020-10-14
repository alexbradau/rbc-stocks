import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDowJonesIndex } from 'app/shared/model/dow-jones-index.model';

@Component({
  selector: 'jhi-dow-jones-index-detail',
  templateUrl: './dow-jones-index-detail.component.html',
})
export class DowJonesIndexDetailComponent implements OnInit {
  dowJonesIndex: IDowJonesIndex | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dowJonesIndex }) => (this.dowJonesIndex = dowJonesIndex));
  }

  previousState(): void {
    window.history.back();
  }
}

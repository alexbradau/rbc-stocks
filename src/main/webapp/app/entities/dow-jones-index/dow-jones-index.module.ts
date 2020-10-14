import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RbcstocksSharedModule } from 'app/shared/shared.module';
import { DowJonesIndexComponent } from './dow-jones-index.component';
import { DowJonesIndexDetailComponent } from './dow-jones-index-detail.component';
import { dowJonesIndexRoute } from './dow-jones-index.route';

@NgModule({
  imports: [RbcstocksSharedModule, RouterModule.forChild(dowJonesIndexRoute)],
  declarations: [DowJonesIndexComponent, DowJonesIndexDetailComponent],
})
export class RbcstocksDowJonesIndexModule {}

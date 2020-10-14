import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { RbcstocksSharedModule } from 'app/shared/shared.module';
import { RbcstocksCoreModule } from 'app/core/core.module';
import { RbcstocksAppRoutingModule } from './app-routing.module';
import { RbcstocksHomeModule } from './home/home.module';
import { RbcstocksEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    RbcstocksSharedModule,
    RbcstocksCoreModule,
    RbcstocksHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    RbcstocksEntityModule,
    RbcstocksAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class RbcstocksAppModule {}

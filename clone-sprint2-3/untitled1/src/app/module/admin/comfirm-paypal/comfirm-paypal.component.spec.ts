import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComfirmPaypalComponent } from './comfirm-paypal.component';

describe('ComfirmPaypalComponent', () => {
  let component: ComfirmPaypalComponent;
  let fixture: ComponentFixture<ComfirmPaypalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComfirmPaypalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComfirmPaypalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

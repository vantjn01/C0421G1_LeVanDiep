import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhanDetailComponent } from './benhan-detail.component';

describe('BenhanDetailComponent', () => {
  let component: BenhanDetailComponent;
  let fixture: ComponentFixture<BenhanDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhanDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhanDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

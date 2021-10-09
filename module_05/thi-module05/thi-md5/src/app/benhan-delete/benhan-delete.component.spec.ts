import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhanDeleteComponent } from './benhan-delete.component';

describe('BenhanDeleteComponent', () => {
  let component: BenhanDeleteComponent;
  let fixture: ComponentFixture<BenhanDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhanDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhanDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

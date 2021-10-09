import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhanEditComponent } from './benhan-edit.component';

describe('BenhanEditComponent', () => {
  let component: BenhanEditComponent;
  let fixture: ComponentFixture<BenhanEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhanEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhanEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhanCreateComponent } from './benhan-create.component';

describe('BenhanCreateComponent', () => {
  let component: BenhanCreateComponent;
  let fixture: ComponentFixture<BenhanCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhanCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhanCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

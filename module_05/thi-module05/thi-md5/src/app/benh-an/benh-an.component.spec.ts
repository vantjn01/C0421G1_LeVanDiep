import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhAnComponent } from './benh-an.component';

describe('BenhAnComponent', () => {
  let component: BenhAnComponent;
  let fixture: ComponentFixture<BenhAnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhAnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhAnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

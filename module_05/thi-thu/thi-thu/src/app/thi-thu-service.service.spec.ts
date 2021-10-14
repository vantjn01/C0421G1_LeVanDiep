import { TestBed } from '@angular/core/testing';

import { ThiThuServiceService } from './thi-thu-service.service';

describe('ThiThuServiceService', () => {
  let service: ThiThuServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ThiThuServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

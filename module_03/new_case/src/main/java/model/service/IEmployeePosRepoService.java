package model.service;

import model.bean.EmployeePosition;

import java.util.List;

public interface IEmployeePosRepoService {
    List<EmployeePosition> selectAllPosition();
}

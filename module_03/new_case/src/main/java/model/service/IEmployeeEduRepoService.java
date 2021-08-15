package model.service;

import model.bean.EmployeeEducation;

import java.util.List;

public interface IEmployeeEduRepoService {
    List<EmployeeEducation> selectAllEducation();
}

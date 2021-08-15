package model.service.impl;

import model.bean.EmployeeEducation;
import model.repository.IEmployeeEduRepo;
import model.repository.impl.EmployeeEduRepoImpl;
import model.service.IEmployeeEduRepoService;

import java.util.List;

public class EmployeeEduRepoServiceImpl implements IEmployeeEduRepoService {
    IEmployeeEduRepo iEmployeeEduRepo = new EmployeeEduRepoImpl();

    @Override
    public List<EmployeeEducation> selectAllEducation() {
        return this.iEmployeeEduRepo.selectAllEducation();
    }
}

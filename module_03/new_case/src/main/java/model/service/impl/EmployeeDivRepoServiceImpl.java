package model.service.impl;

import model.bean.EmployeeDivision;
import model.repository.IEmployeeDivRepo;
import model.repository.impl.EmployeeDivRepoImpl;
import model.service.IEmployeeDivRepoService;

import java.util.List;

public class EmployeeDivRepoServiceImpl implements IEmployeeDivRepoService {
    IEmployeeDivRepo iEmployeeDivRepo = new EmployeeDivRepoImpl();

    @Override
    public List<EmployeeDivision> selectAllDivision() {
        return this.iEmployeeDivRepo.selectAllDivision();
    }
}

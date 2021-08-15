package model.service;
import model.bean.EmployeeDivision;

import java.util.List;

public interface IEmployeeDivRepoService {
    List<EmployeeDivision> selectAllDivision();
}

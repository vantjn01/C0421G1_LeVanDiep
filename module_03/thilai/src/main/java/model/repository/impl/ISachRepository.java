package model.repository.impl;

import model.bean.Sach;

import java.sql.SQLException;
import java.util.List;

public interface ISachRepository {
    void addNewSach(Sach sach) throws SQLException;

    Sach selectSach(int id);

    List<Sach> selectSach();

//    boolean deleteSach(int id) throws SQLException;
//    //
    boolean updateSach(Sach sach) throws SQLException;
}

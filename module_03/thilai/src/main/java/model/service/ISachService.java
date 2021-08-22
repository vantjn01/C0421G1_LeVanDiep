package model.service;

import model.bean.Sach;

import java.sql.SQLException;
import java.util.List;

public interface ISachService {
    void addNewSach(Sach sach) throws SQLException;

    Sach selectSach(int id);

    List<Sach> selectSach();

//    boolean deleteSach(int id) throws SQLException;
//    //
    boolean updateSach(Sach sach) throws SQLException;
}

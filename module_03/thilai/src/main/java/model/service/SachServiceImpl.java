package model.service;

import model.bean.Sach;
import model.repository.impl.ISachRepository;
import model.repository.impl.SachRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class SachServiceImpl implements ISachService{

    ISachRepository iSachRepository = new SachRepositoryImpl();

    @Override
    public void addNewSach(Sach sach) throws SQLException {
        this.iSachRepository.addNewSach(sach);
    }

    @Override
    public Sach selectSach(int id) {
        return this.iSachRepository.selectSach(id);
    }

    @Override
    public List<Sach> selectSach() {
        return this.iSachRepository.selectSach();
    }

    @Override
    public boolean updateSach(Sach sach) throws SQLException {
        return this.iSachRepository.updateSach(sach);
    }
}

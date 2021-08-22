package model.repository.impl;

import model.bean.Sach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachRepositoryImpl implements ISachRepository{
    private static final String INSERT_SACH_SQL = "INSERT INTO sach" + "  (id_sach," +
            " ten_sach, tac_gia, mo_ta, so_luong) VALUES " +
            " (?, ?, ?, ?, ?);";
    private static final String SELECT_SACH_BY_ID = "select * from sach where id_sach =?";
    private static final String SELECT_ALL_SACH = "select * from sach";

    private static final String SELECT_UPDATE_Sach = "update sach\n" +
            "set  ten_sach = ?,tac_gia = ?,mo_ta = ?,so_luong=?\n" +
            "where id_sach = ?";

    BaseRepository baseRepository = new BaseRepository();

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    @Override
    public void addNewSach(Sach sach) throws SQLException {
        System.out.println(INSERT_SACH_SQL);
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_SACH_SQL);
            preparedStatement.setString(1, sach.getTen_sach());
            preparedStatement.setString(2, sach.getTac_gia());
            preparedStatement.setString(3, sach.getMo_ta());
            preparedStatement.setInt(4, sach.getSo_luong());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Sach selectSach(int id) {
        Sach sach = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_SACH_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ten_sach = resultSet.getString("ten_sach");
                String tac_gia = resultSet.getString("tac_gia");
                String mo_ta = resultSet.getString("mo_ta");
                int so_luong = resultSet.getInt("so_luong");
                sach = new Sach(id, ten_sach,tac_gia,mo_ta,so_luong);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return sach;
    }

    @Override
    public List<Sach> selectSach() {
        List<Sach> sachList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_SACH);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_sach = resultSet.getInt("id_sach");
                String ten_sach = resultSet.getString("ten_sach");
                String tac_gia = resultSet.getString("tac_gia");
                String mo_ta = resultSet.getString("mo_ta");
                int so_luong = resultSet.getInt("so_luong");
               sachList.add(new Sach(id_sach,ten_sach,tac_gia,mo_ta,so_luong));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sachList;
    }

    @Override
    public boolean updateSach(Sach sach) throws SQLException {
        boolean rowUpdated = false;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_UPDATE_Sach);
        {
            System.out.println(preparedStatement);

            preparedStatement.setString(1, sach.getTen_sach());

            preparedStatement.setString(2, sach.getTac_gia());
            preparedStatement.setString(3, sach.getMo_ta());
            preparedStatement.setInt(4, sach.getSo_luong());


            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}


package dao.impl;

import dao.GenericDAO;
import mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbtractDAO<T> implements GenericDAO<T> {
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/news";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }

    }

    public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<T> results = new ArrayList<T>();
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            setParameters(ps, parameters);
            rs = ps.executeQuery();
            while (rs.next()) {
                T t = rowMapper.mapRow(rs);
                results.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return results;
    }

    public void insert(String sql, Object... parameter) {

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            setParameters(ps, parameter);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void update(Long id, String sql, Object... parameter) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            setParameters(ps, parameter);
            ps.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void setParameters(PreparedStatement ps, Object... parametera) {
        try {
            int length = parametera.length;
            for (int i = 0; i < length; i++) {
                int index = i + 1;
                Object parameter = parametera[i];
                if (parameter instanceof String) {
                    ps.setString(index, (String) parameter);
                }
                if (parameter instanceof Long) {
                    ps.setLong(index, (Long) parameter);
                }
                if (parameter instanceof Timestamp) {
                    ps.setTimestamp(index, (Timestamp) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

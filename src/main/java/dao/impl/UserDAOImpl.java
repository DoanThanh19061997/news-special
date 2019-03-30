package dao.impl;

import dao.IUserDAO;
import mapper.RowMapper;
import mapper.UserMapper;
import model.User;

import java.sql.ResultSet;
import java.util.List;

public class UserDAOImpl extends AbtractDAO<User> implements IUserDAO {
    public User findUserByUserNameAndPassword(String userName, String userPassword) {

        String sql ="SELECT * FROM user WHERE username =? AND password=?";
       List<User> user = query(sql, new UserMapper(),userName,userPassword);
       return user.isEmpty()?null:user.get(0);
    }
}

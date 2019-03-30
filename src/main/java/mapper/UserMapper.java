package mapper;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs) {
        User user = new User();
        try {
            user.setId(rs.getLong("userid"));
            if (rs.getString("username")!=null){
                user.setUserName(rs.getString("username"));
            }
            if (rs.getString("password")!=null){
                user.setPassword(rs.getString("password"));
            }
            if (rs.getString("firstname")!=null){
                user.setFirstName(rs.getString("firstname"));
            }
            if (rs.getString("lastname")!=null){
                user.setLastName(rs.getString("lastname"));
            }

            user.setCreatedDate(rs.getTimestamp("createddate"));
            if (rs.getString("email")!=null){
                user.setMail(rs.getString("email"));
            }
            user.setSex(rs.getInt("sex"));
            user.setRoleId(rs.getLong("roleid"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

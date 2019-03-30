package mapper;

import model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role>{


    public Role mapRow(ResultSet rs) {
        Role role = new Role();
        try {
            role.setRoleId(rs.getLong("roleid"));
            if (rs.getString("rolename")!=null){
                role.setRoleName(rs.getString("rolename"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
}

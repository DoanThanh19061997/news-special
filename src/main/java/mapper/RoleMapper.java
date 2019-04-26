package mapper;

import model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<RoleModel> {
    public RoleModel mapRow(ResultSet rs) {
        RoleModel roleModel = new RoleModel();
        try {
            roleModel.setRoleId(rs.getLong("roleid"));
            roleModel.setRoleName(rs.getString("rolename"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleModel;
    }
}

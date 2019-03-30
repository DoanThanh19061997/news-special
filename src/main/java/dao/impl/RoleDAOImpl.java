package dao.impl;

import dao.IRoleDAO;
import mapper.RoleMapper;
import mapper.RowMapper;
import model.Role;

import java.util.List;

public class RoleDAOImpl extends AbtractDAO<Role> implements IRoleDAO {
    public Role findRoleById(Long id) {
        String sql = "SELECT * FROM role WHERE roleid = ?";
        List<Role> roles = query(sql, new RoleMapper(), id);
        return roles.isEmpty() ? null : roles.get(0);

    }
}

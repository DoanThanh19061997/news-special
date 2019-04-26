package dao.impl;

import dao.IRoleDao;
import mapper.RoleMapper;
import model.RoleModel;

import java.util.List;

public class RoleDaoImpl extends AbtractDAOI<RoleModel> implements IRoleDao {
    public RoleModel findRoleById(Long id) {
        String sql = "SELECT * FROM role WHERE roleid=?";
        List<RoleModel> roleModels = query(sql, new RoleMapper(), id);
        return roleModels.isEmpty()?null : roleModels.get(0);
    }
}

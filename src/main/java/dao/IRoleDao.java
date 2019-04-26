package dao;

import model.RoleModel;

public interface IRoleDao {
    RoleModel findRoleById(Long id);
}

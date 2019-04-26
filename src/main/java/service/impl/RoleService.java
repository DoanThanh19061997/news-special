package service.impl;

import dao.IRoleDao;
import dao.impl.RoleDaoImpl;
import model.RoleModel;
import service.IRoleService;

public class RoleService implements IRoleService {
    private IRoleDao roleDao;

    public RoleService(){
        this.roleDao = new RoleDaoImpl();
    }

    public RoleModel findRole(Long id) {
        return roleDao.findRoleById(id);
    }
}

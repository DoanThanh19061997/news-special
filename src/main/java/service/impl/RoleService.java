package service.impl;

import dao.IRoleDAO;
import dao.impl.RoleDAOImpl;
import model.Role;
import service.IRoleService;

public class RoleService implements IRoleService {
    IRoleDAO iRoleDAO = new RoleDAOImpl();

    public RoleService() {
    }

    public Role findRoleById(Long id) {
        return iRoleDAO.findRoleById(id);
    }
}

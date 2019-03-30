package security;

import model.Role;
import model.User;
import model.request.Auth;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;

public class AuthenticationImpl implements Authentication {
    private String userName;
    private String userPassword;
    private IUserService userService;
    private IRoleService roleService;

    public AuthenticationImpl(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userService = new UserService();
        this.roleService = new RoleService();
    }

    @Override
    public String urlRedirect() {

        User user = userService.findUserByUserNameAndPassword(new Auth(userName, userPassword));
        if (user != null) {
            /*resp.sendRedirect("/admin");*/
            Role role = roleService.findRoleById(user.getRoleId());
            if (role.getRoleName().equals("ADMIN")) {
                return "/admin";
            } else if (role.getRoleName().equals("USER")) {
                return "/home";
            }
        } else {
            return "/login?message=userNameOrPasswordInvalues";
        }
        return null;
    }
}

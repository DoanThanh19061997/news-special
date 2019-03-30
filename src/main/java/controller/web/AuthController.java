package controller.web;

import Utils.FormUtil;
import model.Role;
import model.User;
import model.request.Auth;
import security.Authentication;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class AuthController extends HttpServlet {
    /*IUserService iUserService = new UserService();*/
    private IUserService userService;
    private IRoleService roleService;

    public AuthController(){
        this.userService = new UserService();
        this.roleService = new RoleService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (message != null && message.equals("userNameOrPasswordInvalues ")) {
            req.setAttribute("message", "tên đăng nhập or mật khẩu bị sai");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");*/
        /*Auth auth = FormUtil.mapToModel(Auth.class, req);
        User user = userService.findUserByUserNameAndPassword(auth);
        if (user != null) {
            *//*resp.sendRedirect("/admin");*//*
           Role role = roleService.findRoleById(user.getRoleId());
           if (role.getRoleName().equals("ADMIN")){
               resp.sendRedirect("/admin");
           }else if (role.getRoleName().equals("USER")){
               resp.sendRedirect("/home");
           }
        } else {
            resp.sendRedirect("/login?message=userNameOrPasswordInvalues");
        }*/

        Auth auth = FormUtil.mapToModel(Auth.class,req);
        User user = userService.findUserByUserNameAndPassword(auth);
        String url = Authentication.newModel(auth.getUserName(),auth.getPassword()).urlRedirect();
        resp.sendRedirect(url);


    }
}

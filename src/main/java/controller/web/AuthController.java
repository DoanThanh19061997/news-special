package controller.web;

import Utils.FormUtil;
import model.User;
import model.request.Auth;
import service.IUserService;
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
    IUserService iUserService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (message != null && message.equals("userNameOrPasswordInvalues ")){
            req.setAttribute("message","tên đăng nhập or mật khẩu bị sai");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");*/
        Auth auth = FormUtil.mapToModel(Auth.class,req);
        User user = iUserService.findUserByUserNameAndPassword(auth);
        if (user !=null){
            resp.sendRedirect("/admin");
        }
        else {
            resp.sendRedirect("/login?message=userNameOrPasswordInvalues");
        }
    }
}

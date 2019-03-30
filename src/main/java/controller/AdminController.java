package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* TODO: Thằng decorators nó giúp việc tìm các giao diện và áp giao diện thông qua
* đường dẫn vào web
* VD: /admin thì thằng filter trong file web.xml nó sẽ đi vào trong file
* decorators tìm ra ra có cái pattern nào là /admin k
* nếu có nó sẽ đi vào thư mục directory decorators để áp giao diện tổng
*
*
* */
//đường dẫn admin đi vào web.xml
//sau đó vào decorators.xml
@WebServlet("/admin")
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/admin/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

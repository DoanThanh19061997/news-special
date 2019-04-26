package controller.admin;

import model.CategoryModel;
import model.NewsModel;
import service.ICategorySevice;
import service.INewsService;
import service.impl.CategorySeviceImpl;
import service.impl.NewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/news")
public class NewsController extends HttpServlet {
    private INewsService iNewsService;
    private ICategorySevice categorySevice;

    public NewsController() {
        this.iNewsService = new NewsService();
        this.categorySevice = new CategorySeviceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type =req.getParameter("type");
        String view =" ";
        if (type!=null){
            if (type.equals("edit")){
               /* String i = req.getParameter("id");
                Long id = Long.parseLong(i);
                NewsModel newsModel = iNewsService.findOneById(id);
                List<CategoryModel> list =categorySevice.findAll();
                req.setAttribute("categories",list);
                req.setAttribute("model",newsModel);*/

            }else if (type.equals("create")){

            }
            view ="/views/admin/news/edit.jsp";
        }else {
            view ="/views/admin/news/list.jsp";
        }
        /*else {
            List<NewsModel> list = iNewsService.findAll();
            req.setAttribute("models",list);
        }*/

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

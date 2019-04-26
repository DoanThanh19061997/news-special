package controller.admin.api;

import model.NewsModel;
import service.INewsService;
import service.impl.NewsService;
import utils.MapJsonToModelUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/news")
public class NewApiController extends HttpServlet {
    private INewsService iNewsService;

    public NewApiController() {
        iNewsService = new NewsService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        NewsModel news = MapJsonToModelUtils.of(req.getReader()).toModel(NewsModel.class);
//        UserModel user = (UserModel) SessionUtil.getSessionUtilIntance().getValue(req, "MODEL");
//        news.setCreatedBy(user.getUserName());
        iNewsService.createdNews(news);
    }
}

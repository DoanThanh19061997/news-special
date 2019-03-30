package service.impl;

import dao.INewsDAO;
import dao.impl.NewDAOImpl;
import model.News;
import service.INewsService;

import java.sql.Timestamp;

public class NewsService implements INewsService {
    private INewsDAO newsDAO;

    public NewsService() {
        this.newsDAO = new NewDAOImpl();
    }

    public void createdNews(News news) {
        news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        news.setCreatedBy(" ");
        newsDAO.insertNews(news);
    }

    public void updateNews(Long id, News updateNews) {
        News oldNews = newsDAO.findNewsById(id);
        updateNews.setCreatedDate(oldNews.getCreatedDate());
        updateNews.setCreatedBy(oldNews.getCreatedBy());
        updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateNews.setModifiedBy("");
        newsDAO.updateNews(id, updateNews);

    }
}

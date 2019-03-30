package service;

import model.News;

public interface INewsService {
    void  createdNews(News news);
    void updateNews(Long id, News updateNews);
}

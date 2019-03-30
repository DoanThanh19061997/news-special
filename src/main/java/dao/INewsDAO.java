package dao;

import model.News;

import java.sql.SQLException;
import java.util.List;

public interface INewsDAO extends GenericDAO<News> {
    void insertNews(News news);

    void updateNews(Long id, News news);

    News findNewsById(Long id);

    /*News findNewsByString(String timKiem);*/
    List<News> findNewsByString(String timKiem);

    List<News> findAll() throws SQLException;

}

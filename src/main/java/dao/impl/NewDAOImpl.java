package dao.impl;

import dao.INewsDAO;
import mapper.NewsMapper;
import model.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class NewDAOImpl extends AbtractDAO<News> implements INewsDAO {
    public void insertNews(News news) {
        String sql ="INSERT INTO news( title, shortDescription,content,createdBy," +
                "createdDate,thumbnail,status ,categoryID ) VALUES(?,?,?,?,?,?,?,?)" ;
        insert(sql, news.getTitle(),news.getShortDescription(),news.getContent(),news.getCreatedBy(),news.getCreatedDate(),news.getThumbnail(),news.getStatus(),news.getCategoryID());
    }

    public void updateNews(Long id, News news) {
        String sql = "UPDATE news SET title =?,shortDescription=?,content =?,createdBy =?,createdDate=?," +
                " modifiedBy =?, modifiedDate =?, censor=?, " +
                "thumbnail =?, status=?, categoryID=? WHERE id =?" ;

        update(id,sql,news.getTitle(),news.getShortDescription(),
                news.getContent(),news.getCreatedBy(),
                news.getCreatedDate(),news.getModifiedBy(),
                news.getModifiedDate(),news.getCensor(),
                news.getThumbnail(),news.getStatus(),
                news.getCategoryID(), news.getIdNews());
    }

    public News findNewsById(Long id) {
        String sql ="SELECT* FROM news WHERE id = ?";
        List<News> list = query(sql,new NewsMapper(),id);

        return list.isEmpty()?null:list.get(0);
    }

    public List<News> findNewsByString(String timKiem) {
        String sql ="SELECT*FROM news WHERE timKiem LIKE ?";
        List<News> list = query(sql,new NewsMapper(),"%"+timKiem+"%");
    return list;


    }

    public List<News> findAll() throws SQLException {
        String sql ="SELECT * FROM news";
        return query(sql,new NewsMapper());
    }

    public static void main(String[] args) throws SQLException {
      INewsDAO  iNewDAO = new NewDAOImpl();
      News news = new News();
        news.setTitle("abg");
        news.setShortDescription("xx");
        news.setContent("cb");
        news.setCreatedBy("db");
        news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        news.setThumbnail("g4");
        news.setStatus("h5");
        news.setCategoryID(2L);
        iNewDAO.insertNews(news);
    }







}

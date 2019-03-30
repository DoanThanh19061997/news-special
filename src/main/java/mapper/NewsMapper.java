package mapper;

import model.News;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<News> {

    public News mapRow(ResultSet rs) {
        News news = new News();
        try {
            news.setIdNews(rs.getLong("id"));
            if (rs.getString("title") != null) {
                news.setTitle(rs.getString("title"));
            }
            if (rs.getString("shortDescription") != null) {
                news.setShortDescription(rs.getString("shortDescription"));
            }
            if (rs.getString("content") != null) {
                news.setContent(rs.getString("content"));
            }
            if (rs.getString("createdBy") != null) {
                news.setCreatedBy(rs.getString("createdBy"));
            }

            news.setCreatedDate(rs.getTimestamp("createddate"));
            if (rs.getString("modifiedby") != null) {
                news.setModifiedBy(rs.getString("modifiedby"));
            }
            news.setModifiedDate(rs.getTimestamp("modifiedDate"));
            if (rs.getString("censor") != null) {
                news.setCensor(rs.getString("censor"));
            }
            if (rs.getString("thumbnail") != null) {
                news.setThumbnail(rs.getString("thumbnail"));
            }
            if (rs.getString("status") != null) {
                news.setStatus(rs.getString("status"));
            }

            news.setCategoryID(rs.getLong("categoryid"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }


}

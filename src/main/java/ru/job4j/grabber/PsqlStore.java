package ru.job4j.grabber;

import ru.job4j.grabber.utils.SqlRuDateTimeParser;
import ru.job4j.html.SqlRuParse;
import java.io.FileInputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cnn;

    public PsqlStore(Properties cfg) {
       try {
            Class.forName(cfg.getProperty("driver-class-name"));
            cnn = DriverManager.getConnection(
                    cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(Post post) {
     try (PreparedStatement preparedStatement = cnn.prepareStatement("insert into post(namePost, textPost, link, created) values (?, ?, ?, ?)",
                          Statement.RETURN_GENERATED_KEYS)) {
         preparedStatement.setString(1, post.getTitle());
         preparedStatement.setString(2, post.getLink());
         preparedStatement.setString(3, post.getDescription());
         LocalDateTime localDateTime = post.getCreated();
         Timestamp timestamp = Timestamp.valueOf(localDateTime);
         preparedStatement.setTimestamp(4, timestamp);
         preparedStatement.execute();
         try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
             if (generatedKeys.next()) {
                 post.setId(generatedKeys.getInt(1));
             }
         }

     }  catch (Exception e) {
         e.printStackTrace();
     }
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try (PreparedStatement preparedStatement = cnn.prepareStatement("select * from post")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    posts.add(new Post(
                          resultSet.getInt("id"),
                          resultSet.getString("namePost"),
                          resultSet.getString("textPost"),
                          resultSet.getString("link"),
                          resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post findById(int id) {
        Post post = null;
        try (PreparedStatement statement = cnn.prepareStatement("select * from post where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    post = new  Post(
                            resultSet.getInt("id"),
                            resultSet.getString("namePost"),
                            resultSet.getString("textPost"),
                            resultSet.getString("link"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public LocalDateTime isMaxData() {
        LocalDateTime result = null;
        try (PreparedStatement statement = cnn.prepareStatement("select max(created) from post")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                            result = resultSet.getTimestamp(1).toLocalDateTime();
                }
                if (result == null) {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("/Users/aleksandrlitvinov/projects/job4j_grabber/src/main/resources/app.properties")) {
            cfg.load(in);
        }
        PsqlStore psqlStore = new PsqlStore(cfg);
        SqlRuParse sqlRuParse = new SqlRuParse(new SqlRuDateTimeParser());
        Post post = sqlRuParse
                .detail("https:/" + "/www.sql.ru/forum/1336939/java-razrabotchik-moskva-udalyonka-200-300-gross");
        psqlStore.save(post);
        List<Post> list = psqlStore.getAll();
        System.out.println(list.toString());
        System.out.println(psqlStore.findById(1).toString());
    }
}

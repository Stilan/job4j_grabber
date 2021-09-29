package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.Post;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }
    @Override
    public List<Post> list(String link) {
        List<Post> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(link).get();
            Elements listOfPosts = document.select(".postslisttopic");
            for (Element td : listOfPosts) {
                Element href = td.child(0);
                Post post = detail(href.attr("href"));
               list.add(post);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Post detail(String link) {
        Post post = null;
        try {
            Document document = Jsoup.connect(link).get();
            Elements header = document.select(".messageHeader").eq(0);
            Element jobTitle = header.get(0);
            Elements descriptionList = document.select(".msgBody").eq(1);
            Element description = descriptionList.get(0);
            Element footer = document.select(".msgFooter").get(0);
            String dateStr = footer.text().substring(0, footer.text().length() - 52);
            post = new Post(
                    jobTitle.text().substring(0, jobTitle.text().length() - 6),
                    link,
                    description.text(),
                    dateTimeParser.parse(dateStr));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return post;
    }
        public static void main(String[] args) {
        SqlRuParse sqlRuParse = new SqlRuParse(new SqlRuDateTimeParser());
        List<Post> posts = sqlRuParse.list(
                "https:/"+"/www.sql.ru/forum/job-offers/1");
        System.out.println(posts.toString());
        Post post = sqlRuParse
                .detail("https:/"+"/www.sql.ru/forum/1336939/java-razrabotchik-moskva-udalyonka-200-300-gross");
        System.out.println(post.toString());
    }
}

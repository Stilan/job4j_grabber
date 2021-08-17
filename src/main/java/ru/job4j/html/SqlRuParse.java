package ru.job4j.html;

import jdk.jfr.Description;
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

/**
 *  @author Александр Литвинов
 *  @since 11.08.2021
 *
 */

public class SqlRuParse implements Parse {

    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    /**
     * Метод list загружает список всех постов.
     *
     * @param link
     * @return
     */
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

    /**
     * Метод detail загружает все детали одного поста
     *
     * @param link
     * @return
     */
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
        List<Post> posts = sqlRuParse.list("https://www.sql.ru/forum/job-offers/1");
        System.out.println(posts.toString());
        Post post = sqlRuParse.detail(
                "https://www.sql.ru/forum/1336939/java-razrabotchik-moskva-udalyonka-200-300-gross");
        System.out.println(post.toString());
    }
}
//    public static void main(String[] args) throws Exception {
//            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();
//            Elements elms = doc.select(".postslisttopic");
//            for (Element td : elms) {
//                Element href = td.child(0);
//                System.out.println(href.attr("href"));
//                System.out.println(href.text());
//                Element element = td.parent();
//                Element tr = element.child(5);
//                System.out.println(tr.text());
//            }
//        }
//
//}
//        isPostDetails(
//                "https://www.sql.ru/forum/1325330/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t");
//    }
//
//    /**
//     * метод парсит описание и дату создания
//     * @param strPath
//     * @throws IOException
//     */
//    public static void isPostDetails(String strPath) throws IOException {
//        Document d = Jsoup.connect(strPath).get();
//        Elements getDescriptionList = d.select(".msgBody").eq(1);
//        Element description = getDescriptionList.get(0);
//        System.out.println(description.text());
//        Element dateCreation = d.select(".msgFooter").get(0);
//        System.out.println(dateCreation.text().substring(0, 17));
//    }
//
//    public static void main(String[] args) throws IOException {
//        isPostDetails("https://www.sql.ru/forum/1325330/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t");
//    }
//  12 авг 21, 12:28
//  17 окт 07, 14:42
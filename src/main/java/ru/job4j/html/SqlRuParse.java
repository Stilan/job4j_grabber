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
import java.util.List;

/**
 *  @author Александр Литвинов
 *  @since 11.08.2021
 *
 */

public class SqlRuParse {

//    private final DateTimeParser dateTimeParser;
//    private List<Post> list;
//
//
////    public SqlRuParse(DateTimeParser dateTimeParser) {
////        this.dateTimeParser = dateTimeParser;
////    }

    /**
     * Метод list загружает список всех постов.
     *
     * @param link
     * @return
     */
//    @Override
//    public List<Post> list(String link) {
//        try {
//            Document document = Jsoup.connect(link).get();
//            Elements elements1 = document.select(".postslisttopic");
//            for (Element td : elements1) {
//                Element href = td.child(0);
//                Post post  = detail(href.attr("href"));
//                list.add(post);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

    /**
     * Метод detail загружает все детали одного поста
     * @param link
     * @return
     */
//    @Override
//    public Post detail(String link) {
//        Post post = null;
//        try {
//            Document document = Jsoup.connect(link).get();
//            Elements elements1 = document.select(".messageHeader").eq(0);
//            Element element1 = elements1.get(0);
//            Elements elements2 = document.select(".msgBody").eq(1);
//            Element element2 = elements2.get(0);
//            Element element3 = document.select(".msgFooter").get(0);
//            String dateStr  = element3.text().substring(0, element3.text().length() - 53);
//            DateTimeParser dateTimeParse = new SqlRuDateTimeParser();
//            post = new Post(1,
//                    element1.text().substring(4, element1.text().length() - 6),
//                    link,
//                    element2.text(),
//                    dateTimeParse.parse(dateStr));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return post;
//    }
//}
//    public static void main(String[] args) throws Exception {
//        for (int i = 1; i < 6; i++) {
//            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + i).get();
//            Elements elms = doc.select(".postslisttopic");
//            for (Element td : elms) {
//                Element href = td.child(0);
//                System.out.println(href.attr("href"));
//                System.out.println(href.text());
//                Element element = td.parent();
//                Element tr = element.child(5);
//                System.out.println(tr.text());
//            }
//            System.out.println("_____________________");
//        }
//        isPostDetails(
//                "https://www.sql.ru/forum/1325330/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t");
//    }
//
    /**
     * метод парсит описание и дату создания
     * @param strPath
     * @throws IOException
     */
    public static void isPostDetails(String strPath) throws IOException {
        Document d = Jsoup.connect(strPath).get();
        Elements getDescriptionList = d.select(".msgBody").eq(1);
        Element description = getDescriptionList.get(0);
        System.out.println(description.text());
        Element dateCreation = d.select(".msgFooter").get(0);
        System.out.println(dateCreation.text().substring(0, 17));
    }

    public static void main(String[] args) throws IOException {
        isPostDetails("https://www.sql.ru/forum/1325330/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t");
    }
}
package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 *  @author Александр Литвинов
 *  @since 11.08.2021
 *
 */

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
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
        isPostDetails(
                "https://www.sql.ru/forum/1325330/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t");
    }

    /**
     * метод парсит описание и дату создания
     * @param strPath
     * @throws IOException
     */
    public static void isPostDetails(String strPath) throws IOException {
        Document d = Jsoup.connect(strPath).get();
        Elements elements1 = d.select(".msgBody").eq(1);
        Element element = elements1.get(0);
        System.out.println(element.text());
        Element elements2 = d.select(".msgFooter").get(0);
        System.out.println(elements2.text().substring(0, 17));
    }
}

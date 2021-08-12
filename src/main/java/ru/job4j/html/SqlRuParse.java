package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *  @author Александр Литвинов
 *  @since 11.08.2021
 *
 */

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 6; i++) {
            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + i).get();
            Elements elms = doc.select(".postslisttopic");
            for (Element td : elms) {
                Element href = td.child(0);
                System.out.println(href.attr("href"));
                System.out.println(href.text());
                Element element = td.parent();
                Element tr = element.child(5);
                System.out.println(tr.text());
            }
        }
    }
}

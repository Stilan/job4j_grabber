package ru.job4j.grabber.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *  @author Александр Литвинов
 *  @since 11.08.2021
 *
 */
public class SqlRuDateTimeParser implements DateTimeParser {

     private static final Map<String, String> MAP_MONTH = Map.ofEntries(
             Map.entry("янв", "января"),
             Map.entry("фев", "февраля"),
             Map.entry("мар", "марта"),
             Map.entry("апр", "апреля"),
             Map.entry("май", "мая"),
             Map.entry("июн", "июня"),
             Map.entry("июл", "июля"),
             Map.entry("авг", "августа"),
             Map.entry("сен", "сентября"),
             Map.entry("окт", "октября"),
             Map.entry("ноя", "ноября"),
             Map.entry("дек", "декабря")
             );
     private static final  DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dMMMMyy,HH:mm");
    /**
     * Метод принимает строку с дата и преобразует ее в LocalDateTime
     * @param parse входная строка
     * @return LocalDateTime
     */
    @Override
    public LocalDateTime parse(String parse) {
        String[] strDayYearMonth = parse.split(",");
        strDayYearMonth[1] = strDayYearMonth[1].replaceAll("\\s", "");
        String[] strHourMinute = strDayYearMonth[1].split(":");
        if (strDayYearMonth[0].contains("сегодня")) {
           return LocalDate.now().atTime(Integer.parseInt(strHourMinute[0]),
                    Integer.parseInt(strHourMinute[1]));
        } else if (strDayYearMonth[0].contains("вчера")) {
            return LocalDate.now().minusDays(1).atTime(Integer.parseInt(strHourMinute[0]),
                    Integer.parseInt(strHourMinute[1]));
        }
        return getLocalDateTime(parse);
    }

    /**
     * Метод заменяет сокращенное название месяца в строке на полное и преобразует ее в LocalDateTime
     * @param strDataSql входная строка например (4 июл 21, 20:15)
     * @return LocalDateTime
     */
      private LocalDateTime getLocalDateTime(String strDataSql) {
          String[] strNewMonth = strDataSql.split(" ");
          String strD = strDataSql.replace(strNewMonth[1], MAP_MONTH.get(strNewMonth[1]));
         strD = strD.replaceAll("\\s", "");
          return LocalDateTime.parse(strD, DATE_TIME_FORMATTER);
      }

}

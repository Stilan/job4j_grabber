package ru.job4j.grabber.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 *  @author Александр Литвинов
 *  @since 11.08.2021
 *
 */
public class SqlRuDateTimeParser implements DateTimeParser {

     private static final HashMap<String, String> MAP_MONTH = new HashMap<>();
     private static final  DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d MMMM yy, HH:mm");
    /**
     * Метод принимает строку с дата и преобразует ее в LocalDateTime
     * @param parse входная строка
     * @return LocalDateTime
     */
    @Override
    public LocalDateTime parse(String parse) {
        String[] strDayYearMonth = parse.split(",");
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
          MAP_MONTH.put("янв", "января");
          MAP_MONTH.put("фев", "февраля");
          MAP_MONTH.put("мар", "марта");
          MAP_MONTH.put("апр", "апреля");
          MAP_MONTH.put("май", "мая");
          MAP_MONTH.put("июн", "июня");
          MAP_MONTH.put("июл", "июля");
          MAP_MONTH.put("авг", "августа");
          MAP_MONTH.put("сен", "сентября");
          MAP_MONTH.put("окт", "октября");
          MAP_MONTH.put("ноя", "ноября");
          MAP_MONTH.put("дек", "декабря");
          String strD = strDataSql.replace(strNewMonth[1], MAP_MONTH.get(strNewMonth[1]));
          return LocalDateTime.parse(strD, DATE_TIME_FORMATTER);
      }
}

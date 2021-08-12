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
    /**
     * Метод принимает строку с дата и преобразует ее в LocalDateTime
     *
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
          HashMap<String, String> map = new HashMap<>();
          map.put("янв", "января");
          map.put("фев", "февраля");
          map.put("мар", "марта");
          map.put("апр", "апреля");
          map.put("май", "мая");
          map.put("июн", "июня");
          map.put("июл", "июля");
          map.put("авг", "августа");
          map.put("сен", "сентября");
          map.put("окт", "октября");
          map.put("ноя", "ноября");
          map.put("дек", "декабря");
          String strD = strDataSql.replace(strNewMonth[1], map.get(strNewMonth[1]));
          DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d MMMM yy, HH:mm");
          return LocalDateTime.parse(strD, formatter1);
      }
}

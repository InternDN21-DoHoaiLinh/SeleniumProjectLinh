package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatHelper {
    public static String getCurrentDate() {
        LocalDate dateObj = LocalDate.now();
        return formatDate(dateObj);
    }

    public static String getDateFromNowAsString(long number) {
        LocalDate dateObj = LocalDate.now().plusDays(number);
        return formatDate(dateObj);
    }

    public static String formatDate(LocalDate localDate) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("M/d/yyyy");
        return localDate.format(myFormatObj);
    }
}
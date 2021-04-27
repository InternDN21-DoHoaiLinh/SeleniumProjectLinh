package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatHelper {
    private static LocalDate myDateObj = LocalDate.now();

    public static String getCurrentDate() {
        return getDateFromNowAsString(0);
    }

    public static String getDateFromNowAsString(long number) {
        myDateObj = myDateObj.plusDays(number);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }
}
package helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataHelper {
    private static Faker faker = new Faker();
    private static Random random = new Random();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomText(int length) {
        String result = StringUtils.repeat("?", length);
        return faker.letterify(result);
    }

    public static String getRandomPassword() {
        return getRandomText(Constant.DEFAULT_PASSWORD_LENGTH);
    }

    public static String getRandomNumber(int length) {
        String result = StringUtils.repeat("#", length);
        return faker.numerify(result);
    }

    public static String getRandomPIDNumber() {
        return getRandomNumber(Constant.DEFAULT_PID_LENGTH);
    }

    public static String getCurrentDate() {
        LocalDate dateObj = LocalDate.now();
        return formatDate(dateObj);
    }

    public static String getDateFromNow(long numberOfDays) {
        LocalDate dateObj = LocalDate.now().plusDays(numberOfDays);
        return formatDate(dateObj);
    }

    public static String formatDate(LocalDate localDate) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(Constant.DEFAULT_DATE_FORMAT);
        return localDate.format(myFormatObj);
    }
}

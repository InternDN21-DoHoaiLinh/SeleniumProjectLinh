package helpers;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataHelper {
    private static Faker faker = new Faker();
    private static Random random = new Random();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomText(int number) {
        String result = "";
        for(int i = 1;i <= number; i++){
            result += "?";
        }
        return faker.letterify(result);
    }

    public static String getRandomText() {
        return getRandomText(8);
    }

    public static String getRandomNumber(int number) {
        String result = "";
        for(int i = 1;i <= number; i++){
            result += "#";
        }
        return faker.numerify(result);
    }

    public static String getCurrentDate() {
        LocalDate dateObj = LocalDate.now();
        return formatDate(dateObj);
    }

    public static String getDateFromNow(long number) {
        LocalDate dateObj = LocalDate.now().plusDays(number);
        return formatDate(dateObj);
    }

    public static String formatDate(LocalDate localDate) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("M/d/yyyy");
        return localDate.format(myFormatObj);
    }
}

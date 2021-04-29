package helpers;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataHelper {
    private static Faker faker = new Faker();
    private static String stations[] = {"Sài Gòn", "Phan Thiết", "Nha Trang", "Đà Nẵng", "Huế", "Quảng Ngãi"};
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

    public static String getRandomPID(int number) {
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

    public static String getExpiredDate() {
        return getDateFromNow(3);
    }

    public static String getDateFromNow(long number) {
        LocalDate dateObj = LocalDate.now().plusDays(number);
        return formatDate(dateObj);
    }

    public static String formatDate(LocalDate localDate) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("M/d/yyyy");
        return localDate.format(myFormatObj);
    }

    public static String getRandomDateFromNow() {
        return getDateFromNow(random.nextInt(26) + 4);
    }

    public static String getRandomDepartStation() {
        return stations[random.nextInt(6)];
    }

    public static String getRandomArriveStation(String departStation) {
        String result;
        switch (departStation) {
            case "Sài Gòn":
                String arriveStationSG[] = {"Phan Thiết", "Nha Trang", "Đà Nẵng", "Huế", "Quảng Ngãi"};
                result = arriveStationSG[random.nextInt(5)];
                break;
            case "Phan Thiết":
                String arriveStationPT[] = {"Sài Gòn", "Nha Trang", "Đà Nẵng"};
                result = arriveStationPT[random.nextInt(3)];
                break;
            case "Nha Trang":
                String arriveStationNT[] = {"Sài Gòn", "Phan Thiết", "Đà Nẵng", "Huế"};
                result = arriveStationNT[random.nextInt(4)];
                break;
            case "Đà Nẵng":
                String arriveStationDN[] = {"Sài Gòn", "Nha Trang", "Huế", "Quảng Ngãi"};
                result = arriveStationDN[random.nextInt(4)];
                break;
            case "Huế":
                String arriveStationH[] = {"Sài Gòn", "Nha Trang", "Đà Nẵng", "Quảng Ngãi"};
                result = arriveStationH[random.nextInt(4)];
                break;
            default:
                String arriveStationQN[] = {"Sài Gòn", "Nha Trang", "Đà Nẵng", "Huế"};
                result = arriveStationQN[random.nextInt(4)];
                break;
        }
        return result;
    }
}

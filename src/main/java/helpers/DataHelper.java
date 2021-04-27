package helpers;

import com.github.javafaker.Faker;

public class DataHelper {
    private static Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.letterify("?????????");
    }

    public static String getRandomPID() {
        return faker.numerify("##########");
    }
}

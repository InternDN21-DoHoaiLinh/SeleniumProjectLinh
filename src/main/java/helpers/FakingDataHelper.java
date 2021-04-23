package helpers;

import com.github.javafaker.Faker;

public class FakingDataHelper {
    private static Faker faker = new Faker();

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomText() {
        return faker.letterify("?????????");
    }

    public static String randomNumber() {
        return faker.numerify("##########");
    }
}

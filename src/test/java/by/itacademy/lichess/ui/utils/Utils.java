package by.itacademy.lichess.ui.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Utils {
    public static String generateAlphanumericString(){
        int maxLength = 15;
        int minLength = 8;
        return RandomStringUtils.randomAlphanumeric(minLength, maxLength);
    }
}

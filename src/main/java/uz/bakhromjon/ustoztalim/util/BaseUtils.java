package uz.bakhromjon.ustoztalim.util;

import org.apache.commons.lang3.RandomStringUtils;

public class BaseUtils {
    public static String generateUniqueString(Integer count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }
}





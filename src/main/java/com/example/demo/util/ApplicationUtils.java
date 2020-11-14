package com.example.demo.util;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2020-11-14
 */
public class ApplicationUtils {

    private ApplicationUtils() {
    }

    /**
     * @param value the value to check
     * @return the value is empty or not
     */
    public static boolean isStringEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}

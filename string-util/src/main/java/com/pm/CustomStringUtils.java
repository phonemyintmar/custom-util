package com.pm;

import java.util.Arrays;
import java.util.List;

/**
 * @author PM
 * @Created 01/06/2023
 * <p>
 * created by sayr G
 */
public class CustomStringUtils {

    public static String[] stringWithSeparatorToArray(String separator, String originalString) {
        return originalString.split(separator);
    }

    public static List<String> stringWithSeparatorToList(String separator, String originalString) {
        return Arrays.asList(originalString.split(separator));
    }

    public static String arrayToStringWithDelimiter(String delimiter, String[] arr) {
        return String.join(delimiter, arr);
    }

    public static String listToStringWithDelimiter(String delimiter, List<String> list) {
        return String.join(delimiter, list);
    }


}

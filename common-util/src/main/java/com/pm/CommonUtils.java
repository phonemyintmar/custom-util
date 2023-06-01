package com.pm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author PM
 * @Created 01/06/2023
 * <p>
 * created by sayr G
 */
@Slf4j
public class CommonUtils {

    public static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T toObject(String str, Class<T> tClass) {
        if (str.isBlank()) return null;
        try {
            return mapper.readValue(str, tClass);
        } catch (Exception e) {
            log.error("[{}] Can not parse, message: {}, rawStr: {}", e.getClass().getSimpleName(), e.getMessage(), str);
            return null;
        }
    }

    public static String toJson(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("[{}] Can write object as string: {}", e.getClass().getSimpleName(), e.getMessage());
            return o.toString();
        }
    }

    public static LocalDate getLdtFromString(String str, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(str, formatter);
    }


}

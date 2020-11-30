package com.qsystems.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Kornyukhina Sasha
 */
public class JSONWriter {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static String getJSONFromObject(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static String getJSONFromString(String str) throws JsonProcessingException {
        return objectMapper.writeValueAsString(str);
    }
}

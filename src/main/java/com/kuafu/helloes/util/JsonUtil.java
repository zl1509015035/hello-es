package com.kuafu.helloes.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String obj2Json(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("method=obj2Json() is convert error, errorMsg:{}", e.getMessage(), e);
            return null;
        }
    }


    public static void main(String[] args) {
        String str = "123456";
        String s = obj2Json(str);
        System.out.println(s);
    }
}

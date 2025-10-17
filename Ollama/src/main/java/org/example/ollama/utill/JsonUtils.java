package org.example.ollama.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public final class JsonUtils {
    public static final ObjectMapper MAPPER = create();


    private static ObjectMapper create() {
        ObjectMapper m = new ObjectMapper();
        m.findAndRegisterModules();
        m.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return m;
    }


    private JsonUtils() {}
}
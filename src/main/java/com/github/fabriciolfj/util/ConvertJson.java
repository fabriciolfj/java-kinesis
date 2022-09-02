package com.github.fabriciolfj.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJson<T> {

    private ObjectMapper objectMapper;

    public ConvertJson() {
        this.objectMapper = new ObjectMapper();
    }

    public String toJson(T value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public T toObject(final String value, final Class<T> clazz) {
        try {
            return objectMapper.readValue(value, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}

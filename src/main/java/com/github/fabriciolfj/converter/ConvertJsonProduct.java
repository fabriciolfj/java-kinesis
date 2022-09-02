package com.github.fabriciolfj.converter;

import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.util.ConvertJson;

public class ConvertJsonProduct {

    private static ConvertJson convertJson;

    public static ConvertJson getConvert() {
        if (convertJson != null) {
            return convertJson;
        }

        convertJson = new ConvertJson<Product>();
        return convertJson;
    }
}

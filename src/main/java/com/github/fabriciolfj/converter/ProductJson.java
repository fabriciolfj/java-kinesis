package com.github.fabriciolfj.converter;

import com.github.fabriciolfj.entities.Product;

import static com.github.fabriciolfj.converter.ConvertJsonProduct.getConvert;

public class ProductJson {

    public static String toJson(int num) {
        var product = Product.random(num);
        return getConvert().toJson(product);
    }

    public static Product toProduct(final String value) {
        return (Product) getConvert().toObject(value, Product.class);
    }
}

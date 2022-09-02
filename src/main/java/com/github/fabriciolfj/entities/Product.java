package com.github.fabriciolfj.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    
    private String id;
    private String describe;

    public static Product random(int value) {
        return Product.builder()
                .id(UUID.randomUUID().toString())
                .describe("teste" + value)
                .build();
    }
}

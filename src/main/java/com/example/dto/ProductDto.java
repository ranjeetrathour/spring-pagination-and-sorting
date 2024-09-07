package com.example.dto;

import com.example.entity.Category;
import com.example.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String code;
    private Double price;
    private List<Category> category;
    private List<Supplier> supplier;
}

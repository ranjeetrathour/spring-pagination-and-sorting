package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "product_info")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private Double price;

    @ElementCollection
    @Embedded
    private List<Category> category;

    @Embedded
    @ElementCollection
    private List<Supplier> supplier;
}

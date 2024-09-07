package com.example.mapper.mapper;

import com.example.dto.ProductDto;
import com.example.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto productDto);

    default List<Product> toProducts(List<ProductDto> productDtos){
        return productDtos.stream()
                .map(this::toProduct)
                .collect(Collectors.toList());
    }

    default List<ProductDto> toProductDtos(List<Product> products){
        return products.stream()
                .map(this::toProductDto)
                .collect(Collectors.toList());
    }

    default Page<ProductDto> toProductDtoPage(Page<Product> products){
        return products.map(this::toProductDto);
    }
}

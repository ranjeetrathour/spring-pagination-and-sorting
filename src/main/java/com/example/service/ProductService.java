package com.example.service;

import com.example.dto.AllProductsPaginationResponse;
import com.example.dto.ProductDto;
import com.example.entity.Product;
import com.example.genric.GenericPaginationMapper;
import com.example.mapper.mapper.ProductMapper;
import com.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public void saveAllProduct(List<ProductDto> productDtos){
        List<Product> products = productMapper.toProducts(productDtos);
        log.info(products.toString());
        productRepository.saveAll(products);
    }

    public List<ProductDto> findAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = productMapper.toProductDtos(products);
        return productDtos;
    }

    public List<ProductDto> findAllSortedProducts(String field) {
        List<Product> products = productRepository.findAll(Sort.by(Sort.Direction.DESC,field));
        List<ProductDto> productDtos = productMapper.toProductDtos(products);
        return productDtos;
    }

    public AllProductsPaginationResponse findAllProductsByPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);  //get page from
        Page<Product> products = productRepository.findAll(pageable);
        final var response = productMapper.toProductDtoPage(products);
        return GenericPaginationMapper.toAllProductPaginationResponse(response);
    }
}

package com.example.controller;

import com.example.dto.AllProductsPaginationResponse;
import com.example.dto.ProductDto;
import com.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<?> saveAllProducts(@RequestBody List<ProductDto> productDto){
        productService.saveAllProduct(productDto);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/all-products")
    public List<ProductDto> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/all-product-sorted/{field}")
    public List<ProductDto> findAllSortedProducts(@PathVariable String field){
        return productService.findAllSortedProducts(field);
    }

    @GetMapping("/all-product-page")
    public AllProductsPaginationResponse findAllProductsWithPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return productService.findAllProductsByPagination(page, size);
    }

}

package com.example.genric;

import com.example.dto.AllProductsPaginationResponse;
import org.springframework.data.domain.Page;

public class GenericPaginationMapper {
    public static AllProductsPaginationResponse toAllProductPaginationResponse(Page<?> page){
        return AllProductsPaginationResponse.builder()
                .totalElements(page.getNumberOfElements())
                .totalPages(page.getTotalPages())
                .pageSize(page.getSize())
                .pageNumber(page.getNumber())
                .content(page.getContent())
                .lastPage(page.isLast())
                .build();
    }
}

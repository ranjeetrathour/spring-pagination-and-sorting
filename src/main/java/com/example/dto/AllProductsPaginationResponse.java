package com.example.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllProductsPaginationResponse {
    private int pageNumber;

    private long pageSize;

    private int totalElements;

    private int totalPages;

    private boolean lastPage;

    private Object content;
}

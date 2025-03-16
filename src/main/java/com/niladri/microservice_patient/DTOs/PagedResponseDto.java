package com.niladri.microservice_patient.DTOs;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for returning paginated data with sorting metadata
 * @param <T> Type of content in the page
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponseDto<T> {
    private List<T> patientsList;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private String sortField;
    private String sortDirection;
}
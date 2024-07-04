package com.api.resources.services;

import com.api.resources.dto.pagination.PaginationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PaginationService {


    public PaginationDTO getDatapageable(Page<?> pageable, List<?> data){

        int currentPage = pageable.getPageable().getPageNumber()+1;
        Integer nextPage = pageable.isLast() ? null : currentPage + 1;
        Integer previousPage = pageable.isFirst() ? null : currentPage - 1;

        log.info("nextpage:{} -- currentPage:{}  --- previouspage:{}  ",nextPage,currentPage,previousPage);

        return  PaginationDTO.builder()
                .pageSize(pageable.getNumberOfElements())
                .currentPage(currentPage)
                .nextPage(nextPage)
                .previousPage(previousPage)
                .totalPages(pageable.getTotalPages())
                .totalElements(pageable.getTotalElements())
                .data(data)
                .build();

    }



}

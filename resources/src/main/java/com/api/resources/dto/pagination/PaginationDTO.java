package com.api.resources.dto.pagination;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDTO {

    @Schema(description = "pageSize", example = "1")
    public Integer pageSize;

    @Schema(description = "the total elements of the list.", example = "1")
    public Long totalElements;

    @Schema(description = "TotalPages. Default = 1.", example = "1")
    public Integer totalPages;

    @Schema(description = "The currentPage. Default = 1.", example = "1")
    public Integer currentPage;

    @Schema(description = "The next page if exist.", example = "1")
    public Integer nextPage;

    @Schema(description = "The previous page if exist.", example = "1")
    public Integer previousPage;

    @Schema(description = "The information consulted.", example = "1")
    private List<?> data;

}


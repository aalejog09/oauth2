package com.api.resources.util.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ErrorDTO {

   @Schema(description = "Code", example = "E0001")
   private String code;

   @Schema(description = "Description ", example = "Bad Request")
   private String description;

   @Schema(description = "Simple List with the detail of the error ", example = "The are attributes with wrong values")
   private List<String> detail;

}

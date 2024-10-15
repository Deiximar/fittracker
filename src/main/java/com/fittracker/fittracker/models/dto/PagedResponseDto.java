package com.fittracker.fittracker.models.dto;

import java.util.List;
import org.springframework.data.domain.Pageable;
import lombok.Data;

@Data
public class PagedResponseDto {
  private List<ExerciseDto> content;
  private Pageable pageable;
  private int pageNumber;
  private int pageSize;
  private long totalElements;
  private int totalPages;
  private boolean islast;
}
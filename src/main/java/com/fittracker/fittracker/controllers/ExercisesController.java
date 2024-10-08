package com.fittracker.fittracker.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fittracker.fittracker.models.dto.ExerciseDto;
import com.fittracker.fittracker.models.dto.PagedResponseDto;
import com.fittracker.fittracker.services.ExerciseService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExercisesController {

  private final ExerciseService exerciseService;

  @GetMapping
  public ResponseEntity<PagedResponseDto> getAllExercises(@RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size, @RequestParam(required = false) String bodyPart,
      @RequestParam(required = false) String equipment, @RequestParam(required = false) String searchText) {
    Pageable pageable = PageRequest.of(page, size);
    return ResponseEntity.ok(exerciseService.getAllExercises(pageable, bodyPart, equipment, searchText));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ExerciseDto> getExerciseById(@PathVariable Integer id) {
    return ResponseEntity.ok(exerciseService.getExerciseById(id));
  }
}

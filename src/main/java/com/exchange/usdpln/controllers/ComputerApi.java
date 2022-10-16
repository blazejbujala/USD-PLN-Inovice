package com.exchange.usdpln.controllers;

import com.exchange.usdpln.dto.ComputerDto;
import io.swagger.v3.oas.annotations.Operation;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ComputerApi {

    @GetMapping
    @Operation(summary = "List of computers", description = "Get list of all computers")
    ResponseEntity<List<ComputerDto>> getAllComputers();

    @GetMapping("/{id}")
    @Operation(summary = "Get computer", description = "Get computer by id")
    ResponseEntity<ComputerDto> getById(@PathVariable UUID id);

    @PostMapping
    @Operation(summary = "Add computer", description = "Add new computer")
    ResponseEntity<ComputerDto> addComputer(@RequestBody ComputerDto computerDto);

    @GetMapping("/{date}")
    @Operation(summary = "Get computer", description = "Get computer by date")
    ResponseEntity<List<ComputerDto>> getByDate(@PathVariable LocalDate date);

}

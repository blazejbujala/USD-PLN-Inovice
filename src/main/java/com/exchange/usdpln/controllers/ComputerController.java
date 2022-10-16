package com.exchange.usdpln.controllers;

import com.exchange.usdpln.dto.ComputerDto;
import com.exchange.usdpln.services.ComputerService;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/computers", produces = {"application/json;charset=UTF-8"})
public class ComputerController implements ComputerApi {

    ComputerService computerService;

    @Override
    public ResponseEntity<List<ComputerDto>> getAllComputers() {
        log.info("Getting list of all computers");
        return ResponseEntity.ok(computerService.getAll());
    }

    @Override
    public ResponseEntity<ComputerDto> getById(@PathVariable UUID id) {
        log.info("Getting computer dtls with id;" + id);
        return ResponseEntity.ok(computerService.getById(id));
    }

    @Override
    public ResponseEntity<ComputerDto> addComputer(@RequestBody ComputerDto computerDto) {
        log.info("Adding new computer for exchange calculation");
        return ResponseEntity.ok(computerService.add(computerDto));
    }

    @Override
    public ResponseEntity<List<ComputerDto>> getByDate(LocalDate date) {
        log.info("Getting computer with account date:" + date);
        return ResponseEntity.ok(computerService.getByDate(date));
    }
}

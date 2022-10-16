package com.exchange.usdpln.services;

import com.exchange.usdpln.db.GenericRepository;
import com.exchange.usdpln.db.JpaComputerRepository;
import com.exchange.usdpln.dto.ComputerDto;
import com.exchange.usdpln.dto.mappers.ComputerMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComputerService implements GenericRepository<ComputerDto> {

    private final JpaComputerRepository jpaComputerRepository;
    private final ComputerMapper computerMapper;

    @Override
    public ComputerDto add(ComputerDto computer) {
        computer.setId(UUID.randomUUID());
        return computerMapper.toDto(jpaComputerRepository.save(computerMapper.toEntity(computer)));
    }

    @Override
    public ComputerDto getById(UUID id) {
        return computerMapper
            .toDto(jpaComputerRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("NO Computer with id:" + id)));
    }

    @Override
    public List<ComputerDto> getAll() {
        List<ComputerDto> computerList = new ArrayList<>();
        jpaComputerRepository.findAll().forEach(computer -> computerList.add(computerMapper.toDto(computer)));
        return computerList;
    }

    public List<ComputerDto> getByDate(LocalDate date) {
        return getAll()
            .stream()
            .filter(computer -> computer.getAccountDate().equals(date))
            .collect(Collectors.toList());
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public void clear() {
        jpaComputerRepository.deleteAll();
    }
}

package com.exchange.usdpln.dto.mappers;

import com.exchange.usdpln.dto.ComputerDto;
import com.exchange.usdpln.models.Computer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComputerMapper {

    ComputerDto toDto(Computer computer);

    Computer toEntity(ComputerDto company);

}

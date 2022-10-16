package com.exchange.usdpln.dto.mappers;

import com.exchange.usdpln.dto.InvoiceDto;
import com.exchange.usdpln.models.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceDto toDto(Invoice invoice);

    Invoice toEntity(InvoiceDto invoice);

}

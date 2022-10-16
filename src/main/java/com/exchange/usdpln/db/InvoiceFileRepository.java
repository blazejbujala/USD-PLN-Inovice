package com.exchange.usdpln.db;

import com.exchange.usdpln.dto.InvoiceDto;
import com.exchange.usdpln.dto.mappers.InvoiceMapper;
import com.exchange.usdpln.models.Computer;
import com.exchange.usdpln.utilis.JsonService;
import com.exchange.usdpln.utilis.XmlService;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceFileRepository implements GenericRepository<InvoiceDto> {

    private final XmlService xmlService;
    private final JsonService<Computer> jsonService;
    private final JsonService<UUID> uuidJsonService;
    private final InvoiceMapper invoiceMapper;

    @Override
    public InvoiceDto add(InvoiceDto invoiceDto) throws JAXBException, IOException {
        UUID id = UUID.randomUUID();
        invoiceDto.setInvoiceId(id);
        xmlService.saveToXml(invoiceMapper.toEntity(invoiceDto));
        return invoiceDto;
    }

    @Override
    public InvoiceDto getById(UUID id) throws JAXBException, IOException {
        return invoiceMapper
            .toDto(Arrays.stream(xmlService.readFromFile())
            .filter(invoice -> invoice
                .getInvoiceId()
                .equals(id))
            .findFirst()
            .get());
    }

    @Override
    public List getAll() throws JAXBException, IOException {
        return (Arrays.stream(xmlService.readFromFile()).toList());
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public void clear() {
    }

}

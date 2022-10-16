package com.exchange.usdpln.services;

import com.exchange.usdpln.db.GenericRepository;
import com.exchange.usdpln.db.JpaInvoiceRepository;
import com.exchange.usdpln.dto.ComputerDto;
import com.exchange.usdpln.dto.InvoiceDto;
import com.exchange.usdpln.dto.mappers.InvoiceMapper;
import com.exchange.usdpln.models.Invoice;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvoiceService implements GenericRepository<InvoiceDto> {

    private final JpaInvoiceRepository jpaInvoiceRepository;
    private final InvoiceMapper invoiceMapper;

    @Override
    public InvoiceDto add(InvoiceDto invoiceDto) {
        invoiceDto.setInvoiceId(UUID.randomUUID());
        return invoiceMapper.toDto(jpaInvoiceRepository.save(invoiceMapper.toEntity(invoiceDto)));
    }

    @Override
    public InvoiceDto getById(UUID id) {
        return invoiceMapper
            .toDto(jpaInvoiceRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("No invoice with id:" + id)));
    }

    public List<InvoiceDto> getByDate(LocalDate date) {
        return getAll()
            .stream()
            .filter(inv -> inv.getIssueDate().equals(date))
            .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDto> getAll() {
        List<InvoiceDto> invoiceDtoList = new ArrayList<>();
        jpaInvoiceRepository
            .findAll()
            .forEach(invoice -> invoiceDtoList
                .add(invoiceMapper
                .toDto(invoice)));
        return invoiceDtoList;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public void clear() {
        jpaInvoiceRepository.deleteAll();
    }
}

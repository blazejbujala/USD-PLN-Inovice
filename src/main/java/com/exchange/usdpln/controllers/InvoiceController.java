package com.exchange.usdpln.controllers;

import com.exchange.usdpln.dto.ComputerDto;
import com.exchange.usdpln.dto.InvoiceDto;
import com.exchange.usdpln.services.InvoiceService;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/invoices", produces = {"application/json;charset=UTF-8"})
public class InvoiceController implements InvoiceApi {

    InvoiceService invoiceService;

    @Override
    public ResponseEntity<List<InvoiceDto>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAll());
    }

    @Override
    public ResponseEntity<InvoiceDto> getById(UUID id) {
        return ResponseEntity.ok(invoiceService.getById(id));
    }

    @Override
    public ResponseEntity<InvoiceDto> addInvoice(InvoiceDto invoiceDto) {
        return ResponseEntity.ok(invoiceService.add(invoiceDto));
    }

    @Override
    public ResponseEntity<List<InvoiceDto>> getByDate(LocalDate date) {
        return ResponseEntity.ok(invoiceService.getByDate(date));
    }
}


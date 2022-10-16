package com.exchange.usdpln.controllers;

import com.exchange.usdpln.dto.ComputerDto;
import com.exchange.usdpln.dto.InvoiceDto;
import io.swagger.v3.oas.annotations.Operation;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface InvoiceApi {
    @GetMapping
    @Operation(summary = "Get all invoices", description = "Get all invoices")
    ResponseEntity<List<InvoiceDto>> getAllInvoices();

    @GetMapping("/{id}")
    @Operation(summary = "Get invoice", description = "Get invoice by id")
    ResponseEntity<InvoiceDto> getById(@PathVariable UUID id);

    @PostMapping
    @Operation(summary = "Add invoice", description = "Add new invoice")
    ResponseEntity<InvoiceDto> addInvoice(@RequestBody InvoiceDto invoiceDto);

    @GetMapping("/{date}")
    @Operation(summary = "Get invoice", description = "Get invoice by date")
    ResponseEntity<List<InvoiceDto>> getByDate(@PathVariable LocalDate date);

}

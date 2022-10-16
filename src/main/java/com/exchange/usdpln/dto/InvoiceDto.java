package com.exchange.usdpln.dto;

import com.exchange.usdpln.models.Computer;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private UUID invoiceId;
    private LocalDate issueDate;
    private List<Computer> computers;

}

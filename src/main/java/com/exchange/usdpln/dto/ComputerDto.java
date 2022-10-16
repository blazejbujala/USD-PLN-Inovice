package com.exchange.usdpln.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDto {

    private UUID id;
    private String name;
    private LocalDate accountDate;
    private BigDecimal usdCost;
    private BigDecimal plnCost;

}

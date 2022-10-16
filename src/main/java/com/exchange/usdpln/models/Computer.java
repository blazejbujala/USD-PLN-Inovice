package com.exchange.usdpln.models;

import com.exchange.usdpln.utilis.RateService;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6", required = true)
    @Column(name = "computer_id")
    private UUID id;
    @ApiModelProperty(example = "Administration", required = true)
    @Column(name = "name")
    private String name;
    @ApiModelProperty(example = "2022-01-01", required = true)
    @Column(name = "account_date")
    private LocalDate accountDate;
    @ApiModelProperty(example = "259.39", required = true)
    @Column(name = "usd_Cost")
    private BigDecimal usdCost;
    @ApiModelProperty(example = "120.50", required = true)
    @Column(name = "pln_Cost")
    private BigDecimal plnCost;

    @PrePersist
    public void calculatePlnCost() {
        RateService rateService = new RateService();
        this.plnCost = usdCost.multiply(rateService.getExchangeRate(accountDate.toString())).setScale(2, RoundingMode.HALF_UP);
    }

}

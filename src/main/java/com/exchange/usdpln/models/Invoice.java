package com.exchange.usdpln.models;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
public class Invoice {

    @Id
    @GeneratedValue
    @ApiModelProperty(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6", required = true)
    @Column(name = "invoice_id")
    private UUID invoiceId;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "invoice_id")
    @Schema(name = "computers", required = true)
    private List<Computer> computers;

}

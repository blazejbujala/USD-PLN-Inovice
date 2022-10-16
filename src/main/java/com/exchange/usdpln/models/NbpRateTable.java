package com.exchange.usdpln.models;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class NbpRateTable {

    private String table;
    private String currency;
    private String code;
    private List<ExchangeRate> rates;

}

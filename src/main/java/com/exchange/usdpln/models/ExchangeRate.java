package com.exchange.usdpln.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExchangeRate {

        private String no;
        private String effectiveDate;
        private String mid;

}

package com.exchange.usdpln.utilis;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RateService {

    NbpTableService nbpTableService = new NbpTableService();

    public BigDecimal getExchangeRate (String date){

        return new BigDecimal(
            nbpTableService
                .getExchangeRate(date)
                .getRates()
                .stream()
                .findFirst()
                .get()
                .getMid());
    }

}

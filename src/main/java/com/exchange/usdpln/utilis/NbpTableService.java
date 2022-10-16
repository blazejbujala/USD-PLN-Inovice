package com.exchange.usdpln.utilis;

import com.exchange.usdpln.models.NbpRateTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class NbpTableService {

    private static final String NBP_URL = "http://api.nbp.pl/api/exchangerates/rates/A/";

    private RestTemplate restTemplate = new RestTemplate();
    private JsonService<NbpRateTable> nbpRateTable = new JsonService<>();

    public NbpRateTable getExchangeRate(String date) {
        String response = getNbpTableForCurrency("usd", date);
        log.info(response);
        return nbpRateTable.toObject(response, NbpRateTable.class);
    }

    private String getNbpTableForCurrency(String currency, String date) {
        return restTemplate.getForObject(NBP_URL + "{currency}//{date}", String.class, currency, date);
    }
}

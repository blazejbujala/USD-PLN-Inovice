package com.exchange.usdpln.controllers;

import com.exchange.usdpln.models.NbpRateTable;
import com.exchange.usdpln.utilis.NbpTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/exchange", produces = {"application/json;charset=UTF-8"})
@Slf4j
@RestController
public class ExchangeController {

    NbpTableService exchangeService = new NbpTableService();

   @GetMapping("/{date}")
    public ResponseEntity<NbpRateTable> getExchangeRate(@PathVariable String date) {
        log.info("Getting Exchange Rate USD/PLN for " + date);
        return ResponseEntity.ok(exchangeService.getExchangeRate(date));
    }
}
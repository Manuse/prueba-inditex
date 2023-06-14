package com.pruebainditex.comercioapi.controllers;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pruebainditex.comercio.api.PricesApi;
import com.pruebainditex.comercio.dto.PriceDTO;
import com.pruebainditex.comercioapi.services.PricesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PricesController implements PricesApi {
	
	private final PricesService pricesService;

	@Override
	public ResponseEntity<PriceDTO> getPrices(LocalDateTime applicationDate, Long product, Long brand) {
		log.info("get prices of applicationDate: " + applicationDate + " producto: " + product + " brand: " + brand);		
		return ResponseEntity.ok(pricesService.getPrice(applicationDate, product, brand));
	}

	
}

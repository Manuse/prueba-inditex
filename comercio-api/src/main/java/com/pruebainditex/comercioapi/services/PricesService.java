package com.pruebainditex.comercioapi.services;

import java.time.LocalDateTime;

import com.pruebainditex.comercio.dto.PriceDTO;

public interface PricesService {
	
	PriceDTO getPrice(LocalDateTime applicationDate, Long productId, Long brandId);
	
}

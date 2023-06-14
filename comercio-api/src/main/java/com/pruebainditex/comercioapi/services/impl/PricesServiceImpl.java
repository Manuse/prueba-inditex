package com.pruebainditex.comercioapi.services.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pruebainditex.comercio.dto.PriceDTO;
import com.pruebainditex.comercioapi.entities.Price;
import com.pruebainditex.comercioapi.exception.NotFoundException;
import com.pruebainditex.comercioapi.mapper.PriceMapper;
import com.pruebainditex.comercioapi.repositories.PriceRepository;
import com.pruebainditex.comercioapi.services.PricesService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PricesServiceImpl implements PricesService {

	private final PriceRepository priceRepository;
	
	private final PriceMapper priceMapper;

	@Override
	public PriceDTO getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
		
		Optional<Price> optPrice = priceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
				productId, brandId, applicationDate, applicationDate);
		
		return optPrice
				.map(priceMapper::toPriceDTO)
				.orElseThrow(() -> new NotFoundException("Price not found"));
		
	}
	
}

package com.pruebainditex.comercioapi.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebainditex.comercioapi.entities.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

	Optional<Price> findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
			Long productId, Long BrandId, LocalDateTime startDate, LocalDateTime endDate);
	
}

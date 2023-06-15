package com.pruebainditex.comercioapi.integrations.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pruebainditex.comercio.dto.PriceDTO;
import com.pruebainditex.comercioapi.entities.Brand;
import com.pruebainditex.comercioapi.entities.Price;
import com.pruebainditex.comercioapi.mapper.PriceMapper;
import com.pruebainditex.comercioapi.mapper.PriceMapperImpl;
import com.pruebainditex.comercioapi.repositories.PriceRepository;
import com.pruebainditex.comercioapi.services.impl.PricesServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PricesServiceImplTest {

	@InjectMocks
	private PricesServiceImpl pricesServiceImpl;
	
	@Mock
	private PriceRepository priceRepository;
	
	@Spy
	private PriceMapper mapper = new PriceMapperImpl();
	
	@Test
	void getPrice_returnPriceDTO_whenIsAllOk(){
		//given
		Price price = Price.builder()
				.brand(new Brand(1l, "zara"))
				.curr("eur")
				.id(1l)
				.endDate(LocalDateTime.now())
				.price(1.0d)
				.priceList(1l)
				.priority(1l)
				.productId(1l)
				.startDate(LocalDateTime.now())
				.build();
		
		when(priceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
				anyLong(), anyLong(), any(), any())).thenReturn(Optional.of(price));
		
		//when
		PriceDTO priceDto = pricesServiceImpl.getPrice(LocalDateTime.now(), 1l, 1l);
		
		//then
		assertThat(priceDto)
		.matches(e -> price.getBrand().getId().equals(e.getBrandId()))
		.matches(e -> price.getPrice().toString().concat(price.getCurr()).equals(e.getPrice()))
		.matches(e -> price.getEndDate().equals(e.getEndDate()))
		.matches(e -> price.getStartDate().equals(e.getStartDate()))
		.matches(e -> price.getPriceList().equals(e.getPriceList()))
		.matches(e -> price.getProductId().equals(e.getProductId()));
	}
}

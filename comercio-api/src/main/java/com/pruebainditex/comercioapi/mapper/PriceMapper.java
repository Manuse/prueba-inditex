package com.pruebainditex.comercioapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.pruebainditex.comercio.dto.PriceDTO;
import com.pruebainditex.comercioapi.entities.Price;

@Mapper
public interface PriceMapper {

	@Mapping(source = "brand.id", target = "brandId")
	@Mapping(source = "priceEntity", target = "price", qualifiedByName = "getPriceFormat")
	PriceDTO toPriceDTO(Price priceEntity);
	
	@Named("getPriceFormat")
	default String getPriceFormat(Price priceEntity){
		return priceEntity.getPrice() + priceEntity.getCurr();
	}
	
}

package com.pruebainditex.comercioapi.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class Price {

	@Id	
	private Long id;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private Long priceList;
	
	private Long productId;
	
	private Long priority;
	
	private Double price;
	
	private String curr;
	
	@ManyToOne
	private Brand brand;
	
}

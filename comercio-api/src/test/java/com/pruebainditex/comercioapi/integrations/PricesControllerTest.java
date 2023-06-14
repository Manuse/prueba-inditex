package com.pruebainditex.comercioapi.integrations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PricesControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void case1Test() throws Exception {
		mvc.perform(get("/price/get-price")
				.param("applicationDate", "2020-06-14T10:00:00.000")
				.param("product", "35455")
				.param("brand", "1"))
		.andExpect(status().isOk())
		.andExpect(content().json("""
				{
				  "productId": 35455,
				  "brandId": 1,
				  "priceList": 1,
				  "startDate": "2020-06-14T00:00:00",
				  "endDate": "2020-12-31T23:59:59",
				  "price": "35.5EUR"
				}
				"""));
	}
	
	@Test
	public void case2Test() throws Exception {
		mvc.perform(get("/price/get-price")
				.param("applicationDate", "2020-06-14T16:00:00.000")
				.param("product", "35455")
				.param("brand", "1"))
		.andExpect(status().isOk())
		.andExpect(content().json("""
				{
				  "productId": 35455,
				  "brandId": 1,
				  "priceList": 2,
				  "startDate": "2020-06-14T15:00:00",
				  "endDate": "2020-06-14T18:30:00",
				  "price": "25.45EUR"
				}
				"""));
	}
	
	@Test
	public void case3Test() throws Exception {
		mvc.perform(get("/price/get-price")
				.param("applicationDate", "2020-06-14T21:00:00.000")
				.param("product", "35455")
				.param("brand", "1"))
		.andExpect(status().isOk())
		.andExpect(content().json("""
				{
				  "productId": 35455,
				  "brandId": 1,
				  "priceList": 1,
				  "startDate": "2020-06-14T00:00:00",
				  "endDate": "2020-12-31T23:59:59",
				  "price": "35.5EUR"
				}
				"""));
	}
	
	@Test
	public void case4Test() throws Exception {
		mvc.perform(get("/price/get-price")
				.param("applicationDate", "2020-06-15T10:00:00.000")
				.param("product", "35455")
				.param("brand", "1"))
		.andExpect(status().isOk())
		.andExpect(content().json("""
				{
				  "productId": 35455,
				  "brandId": 1,
				  "priceList": 3,
				  "startDate": "2020-06-15T00:00:00",
				  "endDate": "2020-06-15T11:00:00",
				  "price": "30.5EUR"
				}
				"""));
	}
	
	@Test
	public void case5Test() throws Exception {
		mvc.perform(get("/price/get-price")
				.param("applicationDate", "2020-06-16T21:00:00.000")
				.param("product", "35455")
				.param("brand", "1"))
		.andExpect(status().isOk())
		.andExpect(content().json("""
				{
				  "productId": 35455,
				  "brandId": 1,
				  "priceList": 4,
				  "startDate": "2020-06-15T16:00:00",
				  "endDate": "2020-12-31T23:59:59",
				  "price": "38.95EUR"
				}
				"""));
	}
	
	@Test
	public void caseNotFoundTest() throws Exception {
		mvc.perform(get("/price/get-price")
				.param("applicationDate", "2020-06-16T21:00:00.000")
				.param("product", "35455")
				.param("brand", "2"))
		.andExpect(status().isNotFound())
		.andExpect(content().json("""
				{
				  "message": "Price not found",
				  "code": 404
				}
				"""));
	} 
}

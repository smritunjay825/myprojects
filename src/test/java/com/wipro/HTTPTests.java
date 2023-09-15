package com.wipro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.wipro.model.Car;



@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HTTPTests {
	
	
	@LocalServerPort
	private int port;
	
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void carByBrand() throws Exception
	{	
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/brand", Car.class)).hasFieldOrProperty("model");
	}
	
	@Test
	public void carByPrice() throws Exception
	{	
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/price", Car.class)).hasFieldOrProperty("model");
	}


}

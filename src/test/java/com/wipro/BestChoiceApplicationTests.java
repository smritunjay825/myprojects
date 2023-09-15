package com.wipro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.wipro.controller.CarController;

@SpringBootTest
class BestChoiceApplicationTests {
	
	@Autowired
	private CarController carController;

	@Test
	void contextLoads() {
	}
	
	
	@Test
	void ControllerLoads() throws Exception {
		//AssertJ provides the assertThat() and other methods
		//to express the test assertions
		assertThat(carController).isNotNull();
	}

}

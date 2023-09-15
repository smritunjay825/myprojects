package com.wipro;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wipro.model.Car;
import com.wipro.repository.CarRespository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = { "com.wipro.controller", "com.wipro.model", "com.wipro.repository",
		"com.wipro.service" })
@EnableAutoConfiguration
@EnableSwagger2
public class BestChoiceApplication {
	//@Autowired
	//CarRespository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(BestChoiceApplication.class, args);
	}
	
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2)
	    		  .select()
	              .apis(RequestHandlerSelectors.basePackage("com.wipro.controller"))
	              .build();
	}

/*	@PostConstruct
	public void init(){
		//System.out.println("Inside save");
		Car c1 = new Car("Hyundai", "i10", "petrol", 2019, 10000, 300000);
     	Car c2 = new Car("Hyundai", "i20", "Diesel", 2018, 20000, 200000);
		Car c3 = new Car("Hyundai", "Verna", "Petrol", 2019, 15000, 250000);
		Car c4 = new Car("Tata", "Nexon", "Petrol", 2019, 5000, 600000);
		Car c5 = new Car("Tata", "Bolt", "Petrol", 2019, 15000, 250000);
		Car c6 = new Car("Maruti Suzuki", "Ciaz", "Petrol", 2019, 5000, 600000);
		Car c7 = new Car("Honda", "Jazz", "Diesel", 2018, 20000, 200000);
	    Car c8 = new Car("Honda", "City", "Petrol", 2019, 15000, 400000);
		Car c9 = new Car("Maruti Suzuki", "Ertiga", "Petrol", 2020, 5000, 600000);
		Car c10 = new Car("Toyota", "Fortuner", "Diesel", 2020, 15000, 1800000);
		Car c11 = new Car("Mahindra", "XUV500", "Diesel", 2018, 30000, 700000);
		Car c12 = new Car("Tata", "Safari", "Petrol", 2016, 45000, 600000);
		Car c13 = new Car("Mahindra", "Scorpio", "Petrol", 2018, 30000, 500000);
		Car c14 = new Car("Toyota", "Innova", "Diesel", 2020, 20000, 1100000);
		Car c15 = new Car("Kia", "Seltos", "Petrol", 2021, 10000, 600000);
		Car c16 = new Car("Audi", "Q7", "Diesel", 2015, 60000, 1200000);
		Car c17 = new Car("Audi", "A3", "Petrol", 2017, 50000, 900000);
		Car c18 = new Car("Maruti Suzuki", "Baleno", "Petrol", 2021, 20000, 600000);
		Car c19 = new Car("Renault", "Kwid Climber", "Petrol", 2017, 60000, 350000);
		Car c20 = new Car("Renault", "Duster", "Diesel", 2018, 50000, 650000);
		
		ArrayList<Car> cars = new ArrayList<Car>();
	cars.add(c1);cars.add(c2);cars.add(c3);cars.add(c4);cars.add(c5);cars.add(c6);cars.add(c7);cars.add(c8);cars.add(c9);cars.add(c10);
		cars.add(c11);cars.add(c12);cars.add(c13);cars.add(c14);cars.add(c15);cars.add(c16);cars.add(c17);cars.add(c18);cars.add(c19);cars.add(c20);
		
	carRepository.saveAll(cars);
		System.out.println("saved");
	}  */

}

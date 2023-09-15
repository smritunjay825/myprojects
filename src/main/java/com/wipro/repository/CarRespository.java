package com.wipro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.Car;

@Repository
public interface CarRespository extends JpaRepository<Car, Integer> {
	public List<Car> findByBrand(String brand);

	public Car findByModel(String model);
	
	public List<Car> findByPrice(Long Price);

}

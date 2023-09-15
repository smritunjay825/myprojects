package com.wipro.service;

import java.util.List;

import com.wipro.model.Car;

public interface CarService {
	public List<String> getbrandList();

	public List<Car> getCarByBrand(String brand);

	public List<Car> getBrandListByPrice(String condition,long price);
}

package com.wipro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.model.Car;
import com.wipro.repository.CarRespository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRespository repo;

	@Override
	public List<String> getbrandList() {
		List<Car> carList = repo.findAll();
		List<String> brandList = new ArrayList<String>();
		for (int i = 0; i < carList.size(); i++) {
			Car cc = carList.get(i);
			if (!brandList.contains(cc.getBrand())) {
				brandList.add(cc.getBrand());
			}
		}
		return brandList;
	}

	
	@Override
	public List<Car> getBrandListByPrice(String condition,long price) {
		List<Car> carList = repo.findAll();
		List<Car> resultList = new ArrayList<Car>();
		if(condition.equalsIgnoreCase("<")) {
		for(Car car:carList)
		{
			if(car.getPrice()<=500000) {
				resultList.add(car);
			}
		}
		}else {
			for(Car car:carList)
			{
				if(car.getPrice()>500000) {
					resultList.add(car);
				}
			}
		}
		return resultList;
 	}


	@Override
	public List<Car> getCarByBrand(String brand) {
		List<Car> brandCarList = repo.findByBrand(brand);
		return brandCarList;
		
		
	}

}

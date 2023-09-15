package com.wipro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.model.Car;
import com.wipro.service.CarService;

@Controller
@EnableAutoConfiguration

public class CarController {
	@Autowired
	CarService service;

	List<String> colList = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;

		{
			add(" ");
			add("Brand");
			add("Model");
			add("Year");
			add("No. of Kms");
			add("Price");
			add("Fuel");
		}
	};

	@GetMapping("/")
	public ModelAndView getIndex(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@PostMapping("/getByBrand")
	public ModelAndView getByBrand(@RequestParam String selectBrand, @RequestParam String buttonValue, Model model) {
		ModelAndView mv = new ModelAndView();
		if (buttonValue.equalsIgnoreCase("back")) {
			mv.setViewName("index");
		} else {
			List<Car> carList = service.getCarByBrand(selectBrand);
			Car car = new Car();
			model.addAttribute("car", car);
			mv.addObject("colHeads", colList);
			mv.addObject("cars", carList);
			mv.setViewName("display");
		}
		return mv;
	}

	@PostMapping("/showResult")
	public ModelAndView showResult(Model model, @RequestParam String car, @RequestParam String buttonValue) {
		ModelAndView mv = new ModelAndView();
		if (buttonValue.equalsIgnoreCase("back")) {
			List<String> brandList = service.getbrandList();
			model.addAttribute("brands", brandList);
			mv.setViewName("models");
		} else if (buttonValue.equalsIgnoreCase("Home")) {
			mv.setViewName("index");
		} else {
			model.addAttribute("bookedCar", car);
			mv.setViewName("result");
		}
		return mv;
	}
	@PostMapping("/showResult2")
	public ModelAndView showResult2(Model model, @RequestParam String car, @RequestParam String buttonValue) {
		ModelAndView mv = new ModelAndView();
		if (buttonValue.equalsIgnoreCase("back")) {
			
			mv.setViewName("mycar");
		} else if (buttonValue.equalsIgnoreCase("Home")) {
			mv.setViewName("index");
		} else {
			model.addAttribute("bookedCar", car);
			mv.setViewName("result");
		}
		return mv;
	}

	@GetMapping("/carbybrand")
	public ModelAndView findModels(Model model) {
		ModelAndView mv = new ModelAndView();
		List<String> brandList = service.getbrandList();
		model.addAttribute("brands", brandList);
		mv.setViewName("models");
		return mv;
	}

	@GetMapping("/carbyprice")
	public String findMyCar() {
		return "mycar";
	}
	
	@PostMapping("/getByPrice")
	public ModelAndView getByPrice(@RequestParam String price_range, @RequestParam String buttonValue, Model model) {
		ModelAndView mv = new ModelAndView();
		List<Car> carList = new ArrayList<Car>();
		if (buttonValue.equalsIgnoreCase("back")) {
			mv.setViewName("index");
		} else {
	
			System.out.println(price_range);
			String[] strarr = price_range.split(" ");
			if(strarr[0].equalsIgnoreCase("<"))
			{
				carList = service.getBrandListByPrice(strarr[0], 500000);
				
			}else {
				carList = service.getBrandListByPrice(">", 500000);
			}
			Car car = new Car();
			model.addAttribute("car", car);
			mv.addObject("colHeads", colList);
			mv.addObject("cars", carList);
			mv.setViewName("display2");
		}
		return mv;
	}

}

package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import com.example.dao.CountryRepository;
import com.example.exception.CountryNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.spring.guides.gs_web_service.Country;

@RestController
public class ControllerRS {

	private static final String template = "Ok, %s!";
	private final AtomicLong counter = new AtomicLong();
	private CountryRepository countryRepository;

	@Autowired
	public ControllerRS(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@GetMapping("/hello")
	public Hello hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Hello(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/country")
	public Country getCountry(@RequestBody Country country) {

		Country found = countryRepository.findCountry(country.getName());

		if (found != null) {
			return found;
		} else {
			throw new CountryNotFoundException(country.getName());
		}
	}
}
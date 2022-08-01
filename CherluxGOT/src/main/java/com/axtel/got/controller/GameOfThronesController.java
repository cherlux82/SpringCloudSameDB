package com.axtel.got.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

@RestController
@RequestMapping("/api/v1/gameofthrones/characters")
public class GameOfThronesController {

	private Faker faker = new Faker();
	private List<String> characters = new ArrayList<>();

	@PostConstruct
	public void init() {
		for (int i = 0; i < 20; i++)
			characters.add(faker.gameOfThrones().character());
	}

	@GetMapping
	public ResponseEntity<List<String>> get() {
		return ResponseEntity.ok(characters);
	}
}

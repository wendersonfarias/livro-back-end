package com.wenderson.java.back.end.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping
	public String getMessage() {
		return "<h1>Ola mundo!</h1> <button>Ola</button>";
	}
}

package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(HttpStatus.NOT_FOUND)
class StrNotFound extends RuntimeException {
	String message;

	public StrNotFound(String message) {
		super();
		this.message = message;
	}
}

@RestController
public class StrController {

	static List<String> list = new ArrayList<>();
	static {
		list.add("hello");
		list.add("chirag");
		list.add("matta");

	}

	// http://localhost:8080/getStrings
	@GetMapping("/getStrings")
	public String getString() {
		return list.toString();
	}

	// http://localhost:8080/getStrings/hello
	@GetMapping("/getStrings/{var}")
	public boolean getString(@PathVariable String var) {
		if (list.contains(var))
			return true;
		else
			throw new StrNotFound("not found " + var);
	}

	// http://localhost:8080/deleteString/hello
	@DeleteMapping("/deleteString/{var}")
	public String deleteString(@PathVariable String var) {
		list.remove(var);
		return list.toString();
	}

	// http://localhost:8080/postString/hello
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/postString/{var}")
	public String postString(@PathVariable String var) {
		list.add(var);
		return list.toString();
	}

	// http://localhost:8080/postString/hello
	@PutMapping("/putString/{var}")
	public String putString(@PathVariable String var) {
		list.add(var);
		return list.toString();
	}

}

package kodlamaio.northwind.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;

@RestController
@CrossOrigin
@RequestMapping("/api/users/") /// localhost//api/products için adres
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {

		this.userService = userService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
//		ErrorDataResult<Object> errors = 
		return new ErrorDataResult<Object>(validationErrors, "Validation Hataları!");
	}

	@GetMapping("getall") // HTTP "GET" isteğinde /getAll adresi için bunu çağır
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}/// * /////

	@GetMapping("getByEmail") // HTTP "GET" isteğinde /getAll adresi için bunu çağır
	public DataResult<User> getByEmail(@RequestParam() String email) {
		return this.userService.findByEmail(email);
	}/// * /////
}
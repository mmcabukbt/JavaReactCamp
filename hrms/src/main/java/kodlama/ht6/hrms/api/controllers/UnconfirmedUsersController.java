package kodlama.ht6.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.ht6.hrms.core.business.abstracts.UnconfirmedUserService;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/unconfirmedUsers")
public class UnconfirmedUsersController {

	private UnconfirmedUserService unconfirmedUserService;

	@Autowired
	public UnconfirmedUsersController(UnconfirmedUserService unconfirmedUserService) {
		super();
		this.unconfirmedUserService = unconfirmedUserService;
	}

	@GetMapping("/getall")
	public DataResult<List<UnconfirmedUser>> getAll() {
		return this.unconfirmedUserService.getAll();
	}
}

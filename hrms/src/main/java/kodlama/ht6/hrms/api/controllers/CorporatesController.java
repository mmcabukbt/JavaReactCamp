package kodlama.ht6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.ht6.hrms.business.abstracts.CorporateService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.concretes.Corporate;

@RestController
@RequestMapping("/api/corporates")
public class CorporatesController {

	private CorporateService corporateService;

	@Autowired
	public CorporatesController(CorporateService corporateService) {
		super();
		this.corporateService = corporateService;
	}

	@GetMapping("/getall")
	public DataResult<List<Corporate>> getAll() {
		return this.corporateService.getAll();
	}
}
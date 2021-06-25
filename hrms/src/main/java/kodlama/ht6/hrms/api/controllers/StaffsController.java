package kodlama.ht6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.ht6.hrms.core.business.abstracts.StaffService;
import kodlama.ht6.hrms.core.entities.concretes.Staff;
import kodlama.ht6.hrms.core.utilities.results.DataResult;

@RestController
@CrossOrigin
@RequestMapping("/api/staffs")
public class StaffsController {
	
	private final StaffService staffService;
	
	@Autowired
	public StaffsController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}

	@GetMapping("/getall")
	public DataResult<List<Staff>> getAll(){
		return this.staffService.getAll();		
	}
}
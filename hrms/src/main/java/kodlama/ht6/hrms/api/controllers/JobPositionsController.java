package kodlama.ht6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kodlama.ht6.hrms.business.abstracts.JobPositionService;
import kodlama.ht6.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/JobPositions")	///localhost//api/products için adres
public class JobPositionsController {
	
	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")		//HTTP "GET" isteğinde /getAll adresi için bunu çağır
	public List<JobPosition> getAll(){
		return  this.jobPositionService.getAll();		
	}
/*
	@GetMapping("/getbytopcategory")
	@ResponseBody
	public List<JobPosition> getByTopCategoryId(@RequestParam(defaultValue = "1") String id){
		return this.jobPositionService.getByTopCategoryId(Integer.parseInt(id));		
	}
	
	@GetMapping("/getbysubcategory")
	@ResponseBody
	public List<JobPosition> getBySubCategoryId(@RequestParam(defaultValue = "1") String id){
		return this.jobPositionService.getBySubCategoryId(Integer.parseInt(id));		
	}///*///
}

package kodlama.ht6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kodlama.ht6.hrms.business.abstracts.JobService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")	///localhost//api/products için adres
public class JobController {
	
	private JobService jobService;
	
	@Autowired
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@PostMapping("/add")		//HTTP "GET" isteğinde /getAll adresi için bunu çağır
	public DataResult<Job> add(@RequestBody Job job){
		return this.jobService.add(job);
	}

	@GetMapping("/getall")		//HTTP "GET" isteğinde /getAll adresi için bunu çağır
	public DataResult<List<Job>> getAll(){
		return this.jobService.getAll();		
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

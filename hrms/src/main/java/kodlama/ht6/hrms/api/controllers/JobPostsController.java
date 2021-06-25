package kodlama.ht6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.ht6.hrms.business.abstracts.CityService;
import kodlama.ht6.hrms.business.abstracts.JobPostService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.Dtos.JobPostAddDto;
import kodlama.ht6.hrms.entities.Dtos.JobPostStatusUpdateDto;
import kodlama.ht6.hrms.entities.concretes.City;
import kodlama.ht6.hrms.entities.concretes.JobPost;

@RestController
@RequestMapping("/api/jobPosts")	
public class JobPostsController {
	
	private final JobPostService jobPostService;
	private final CityService cityService;
	
	@Autowired
	public JobPostsController(JobPostService jobPostService, CityService cityService) {
		super();
		this.jobPostService = jobPostService;
		this.cityService = cityService;
	}
	
	@GetMapping("/getCities")
	public DataResult<List<City>> getCities() {
		return this.cityService.getAll();
	}
	
	@PostMapping("/add")		
	public DataResult<JobPost> add(@RequestBody JobPostAddDto jobPostAddDto){
		return this.jobPostService.add(jobPostAddDto);
	}
	
	@PostMapping("/statusUpdate")		
	public DataResult<JobPost> statusUpdate(@RequestBody JobPostStatusUpdateDto jobPostStatusUpdateDto){
		return this.jobPostService.statusUpdate(jobPostStatusUpdateDto);
	}

	
	@GetMapping("/getAll")		
	public DataResult<List<JobPost>> getAll(){
		return this.jobPostService.getAll();		
	}

	@GetMapping("/getAll_OrderByClosingDateDirection")		
	public DataResult<List<JobPost>> getAll_OrderByClosingDateDirection(@RequestParam boolean isDesc){
		return this.jobPostService.getAll_OrderByClosingDateDirection(isDesc);		
	}	

	@GetMapping("/getAll_ByClosingDateAfter_Now")		
	public DataResult<List<JobPost>> getAll_ByClosingDateAfter_Now(){
		return this.jobPostService.getAll_ByClosingDateAfter_Now();		
	}
	
	@GetMapping("/getAllActive")		
	public DataResult<List<JobPost>> getAllActive(){
		return this.jobPostService.getAllActive();		
	}

	@GetMapping("/getAllActive_OrderByClosingDateDirection")		
	public DataResult<List<JobPost>> getAllActive_OrderByClosingDateDirection(@RequestParam boolean isDesc){
		return this.jobPostService.getAllActive_OrderByClosingDateDirection(isDesc);		
	}
	
	@GetMapping("/getByUserIdOrderByClosingDateIsActiveDirection")		
	public DataResult<List<JobPost>> getByUserIdOrderByClosingDateIsActiveDirection(
			@RequestParam Long userId, @RequestParam boolean isOnlyActive, @RequestParam boolean isDesc) {
		return this.jobPostService.getByUserIdOrderByClosingDateIsActiveDirection(userId, isOnlyActive, isDesc);		
	}

}
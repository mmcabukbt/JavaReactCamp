package kodlama.ht6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.ht6.hrms.business.abstracts.JobService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.concretes.Job;

@RestController
@CrossOrigin
@RequestMapping("/api/jobs")	
public class JobsController {
	
	private final JobService jobService;
	
	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@PostMapping("/add")		
	public DataResult<Job> add(@RequestBody Job job){
		return this.jobService.add(job);
	}//*///

	@GetMapping("/getall")		
	public DataResult<List<Job>> getAll(){
		return this.jobService.getAll();		
	}

}

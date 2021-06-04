package kodlama.ht6.hrms.business.abstracts;

import java.util.List;

import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.concretes.Job;

public interface JobService {
	
	DataResult<Job> add(Job job);
	DataResult<List<Job>> getAll();
	
//	List<JobPosition> getByTopCategoryId(int id);
//	List<JobPosition> getBySubCategoryId(int id);
}

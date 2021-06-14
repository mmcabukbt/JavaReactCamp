package kodlama.ht6.hrms.business.abstracts;

import java.util.List;

import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();	
}

package kodlama.ht6.hrms.business.abstracts;

import java.util.List;

import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.Dtos.JobPostAddDto;
import kodlama.ht6.hrms.entities.Dtos.JobPostStatusUpdateDto;
import kodlama.ht6.hrms.entities.concretes.City;
import kodlama.ht6.hrms.entities.concretes.JobPost;

public interface JobPostService {

	DataResult<JobPost> add(JobPostAddDto jobPostAddDto);
	DataResult<JobPost> statusUpdate(JobPostStatusUpdateDto jobPostStatusUpdateDto);
	DataResult<JobPost> getJobPost(Long id);
	
	DataResult<List<JobPost>> getAll();

	DataResult<List<JobPost>> getAll_OrderByClosingDateDirection(boolean isDesc);
	
	DataResult<List<JobPost>> getAll_ByClosingDateAfter_Now();

	DataResult<List<JobPost>> getAllActive();
	
	DataResult<List<JobPost>> getAllActive_OrderByClosingDateDirection(boolean isDesc);
	
	DataResult<List<JobPost>> getByUserIdOrderByClosingDateIsActiveDirection(long userId, boolean isOnlyActive, boolean isDesc);
}

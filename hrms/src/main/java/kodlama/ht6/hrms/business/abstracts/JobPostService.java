package kodlama.ht6.hrms.business.abstracts;

import java.util.List;

import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.Dtos.JobPostAddDto;
import kodlama.ht6.hrms.entities.Dtos.JobPostStatusUpdateDto;
import kodlama.ht6.hrms.entities.concretes.JobPost;

public interface JobPostService {

	DataResult<JobPost> add(JobPostAddDto jobPostAddDto);
	DataResult<JobPost> statusUpdate(JobPostStatusUpdateDto jobPostStatusUpdateDto);
	DataResult<JobPost> getById(Long id);
	
	DataResult<List<JobPost>> getAll();
	
	DataResult<List<JobPost>> getAll_ByClosingDateAfter_Now();

	DataResult<List<JobPost>> getAllActive();
	
	DataResult<List<JobPost>> getAllActive_OrderByPostingDateDirection(boolean isDesc);
	
	DataResult<List<JobPost>> getByUserIdOrderByPostingDateIsActiveDirection(Long userId, boolean isOnlyActive, boolean isDesc);
}

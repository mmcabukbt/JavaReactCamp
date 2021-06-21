package kodlama.ht6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.business.abstracts.CityService;
import kodlama.ht6.hrms.business.abstracts.JobPostService;
import kodlama.ht6.hrms.business.abstracts.JobService;
import kodlama.ht6.hrms.core.business.abstracts.UserService;
import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.JobPostDao;
import kodlama.ht6.hrms.entities.Dtos.JobPostAddDto;
import kodlama.ht6.hrms.entities.Dtos.JobPostStatusUpdateDto;
import kodlama.ht6.hrms.entities.concretes.City;
import kodlama.ht6.hrms.entities.concretes.Job;
import kodlama.ht6.hrms.entities.concretes.JobPost;

@Service
public class JobPostManager implements JobPostService {

	private final JobPostDao jobPostDao;
	private final JobService jobService;
	private final CityService cityService;
	private final UserService userService;

	@Autowired
	public JobPostManager(JobPostDao jobPostDao, JobService jobService, CityService cityService, UserService userService) {
		super();
		this.jobPostDao = jobPostDao;
		this.jobService = jobService;
		this.cityService = cityService;
		this.userService = userService;
	}

	@Override
	public DataResult<JobPost> add(JobPostAddDto jobPostAddDto) {
		DataResult<User> userExist = this.userService.getUser(jobPostAddDto.getUserId());
		if (!userExist.isSuccess()) {
			return new ErrorDataResult<JobPost>(null, userExist.getMessage());
		}
		DataResult<Job> jobExist = this.jobService.getJob(jobPostAddDto.getJobId());
		if (!jobExist.isSuccess()) {
			return new ErrorDataResult<JobPost>(null, jobExist.getMessage());
		}
		DataResult<City> cityExist = this.cityService.getCity(jobPostAddDto.getCityId());
		if (!cityExist.isSuccess()) {
			return new ErrorDataResult<JobPost>(null, cityExist.getMessage());
		}
		JobPost jobPost = new JobPost(0, 
				userExist.getData(), 
				jobPostAddDto.getDescription(),
				jobPostAddDto.getMinSalary(),
				jobPostAddDto.getMaxSalary(),
				java.sql.Date.valueOf(java.time.LocalDate.now()), 
				jobPostAddDto.getClosingDate(),
				jobPostAddDto.getOpenPositions(),
				jobPostAddDto.isActive(), 
				jobExist.getData(), cityExist.getData());
		return new SuccessDataResult<JobPost>(this.jobPostDao.save(jobPost), "JobPost added!");
	}
	
	@Override
	public DataResult<JobPost> statusUpdate(JobPostStatusUpdateDto jobPostStatusUpdateDto) {
		DataResult<JobPost> JobPostExist = this.getJobPost(jobPostStatusUpdateDto.getJobPostId());
		if (!JobPostExist.isSuccess()) {
			return new ErrorDataResult<JobPost>(null, JobPostExist.getMessage());
		}
		if (JobPostExist.getData().getUser().getId() != jobPostStatusUpdateDto.getUserId()) {
			return new ErrorDataResult<JobPost>(null, "[JobPostService]> JobPost> Incorrect or incomplete input!");
		}
		JobPostExist.getData().setActive(jobPostStatusUpdateDto.isActive());
		return new SuccessDataResult<JobPost>(this.jobPostDao.save(JobPostExist.getData()), "JobPost Updated!");
	}
	
	@Override
	public DataResult<JobPost> getJobPost(Long id) {
		JobPost getJobPost = this.jobPostDao.getByid(id);
		return getJobPost == null ? new ErrorDataResult<JobPost>(null, "[JobPostService]> JobPost> Not found!")
				: new SuccessDataResult<JobPost>(getJobPost, "[JobPostService]> JobPost> Already exists!");
	}
	
	@Override
	public DataResult<List<JobPost>> getAll() {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAll(), "All JobPosts listed!");
	}
		
	@Override
	public DataResult<List<JobPost>> getAll_OrderByClosingDateDirection(boolean isDesc) {
		Sort sort = Sort.by(isDesc ? Sort.Direction.DESC : Sort.Direction.ASC, "closingDate");
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAll(sort), "All JobPosts Ordered listed!(Ordered By ASC or DESC)");
	}
	
	@Override
	public DataResult<List<JobPost>> getAll_ByClosingDateAfter_Now() {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findByClosingDateAfter(
				java.sql.Date.valueOf(java.time.LocalDate.now())), "All OPEN JobPosts listed!");
	}
	
	@Override
	public DataResult<List<JobPost>> getAllActive() {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findByActiveTrue(), "All ACTIVE JobPosts listed!");
	}	//*///

	public DataResult<List<JobPost>> getAllActive_OrderByClosingDateDirection(boolean isDesc) {
		return new SuccessDataResult<List<JobPost>>(				
			isDesc ? this.jobPostDao.findByActiveTrueOrderByClosingDateDesc()
				   : this.jobPostDao.findByActiveTrueOrderByClosingDate()
				, "All ACTIVE JobPosts listed! (Ordered By ASC or DESC)");
	}

	@Override
	public DataResult<List<JobPost>> getByUserIdOrderByClosingDateIsActiveDirection(long userId, boolean isOnlyActive, boolean isDesc) {
		return new SuccessDataResult<List<JobPost>>( isOnlyActive?				
				isDesc ? this.jobPostDao.findByUserIdAndActiveTrueOrderByClosingDateDesc(userId)
						: this.jobPostDao.findByUserIdAndActiveTrueOrderByClosingDate(userId)
				: isDesc ? this.jobPostDao.findByUserIdOrderByClosingDateDesc(userId)
						: this.jobPostDao.findByUserIdOrderByClosingDate(userId)
						, "User's All (ACTIVE or INACTIVE JobPosts listed! (Ordered By ASC or DESC)");
	}
}

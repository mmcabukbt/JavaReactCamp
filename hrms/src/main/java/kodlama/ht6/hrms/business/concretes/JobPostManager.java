package kodlama.ht6.hrms.business.concretes;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		DataResult<User> userExist = this.userService.getById(jobPostAddDto.getUserId());
		if (!userExist.isSuccess()) {
			return new ErrorDataResult<JobPost>(null, userExist.getMessage());
		}
		DataResult<Job> jobExist = this.jobService.getById(jobPostAddDto.getJobId());
		if (!jobExist.isSuccess()) {
			return new ErrorDataResult<JobPost>(null, jobExist.getMessage());
		}
		DataResult<City> cityExist = this.cityService.getById(jobPostAddDto.getCityId());
		if (!cityExist.isSuccess()) {
			return new ErrorDataResult<JobPost>(null, cityExist.getMessage());
		}
		JobPost jobPost = new JobPost(0L, 
				userExist.getData(), 
				jobPostAddDto.getDescription(),
				jobPostAddDto.getMinSalary(),
				jobPostAddDto.getMaxSalary(),

				Date.from(Instant.now()), //or on SQL DEFAULT now() column
				jobPostAddDto.getClosingDate(),
				jobPostAddDto.getOpenPositions(),
				jobPostAddDto.isActive(), 
				jobExist.getData(), cityExist.getData());
		return new SuccessDataResult<JobPost>(this.jobPostDao.save(jobPost), "JobPost added!");
	}
	
	@Override
	public DataResult<JobPost> statusUpdate(JobPostStatusUpdateDto jobPostStatusUpdateDto) {
		DataResult<JobPost> JobPostExist = this.getById(jobPostStatusUpdateDto.getJobPostId());
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
	public DataResult<JobPost> getById(Long id) {
		JobPost getJobPost = this.jobPostDao.getByid(id);
		return getJobPost == null ? new ErrorDataResult<JobPost>(null, "[JobPostService]> JobPost> Not found!")
				: new SuccessDataResult<JobPost>(getJobPost, "[JobPostService]> JobPost> Already exists!");
	}
	
	@Override
	public DataResult<List<JobPost>> getAll() {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAll(), "All JobPosts listed!");
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

	public DataResult<List<JobPost>> getAllActive_OrderByPostingDateDirection(boolean isDesc) {
		return new SuccessDataResult<List<JobPost>>(				
			isDesc ? this.jobPostDao.findByActiveTrueOrderByPostingDateDesc()
				   : this.jobPostDao.findByActiveTrueOrderByPostingDate()
				, "All ACTIVE JobPosts listed! >> Ordered by "+ (isDesc? "DESC." : "ASC."));
	}

	@Override
	public DataResult<List<JobPost>> getByUserIdOrderByPostingDateIsActiveDirection(Long userId, boolean isOnlyActive, boolean isDesc) {
		return new SuccessDataResult<List<JobPost>>( isOnlyActive?				
				isDesc ? this.jobPostDao.findByUserIdAndActiveTrueOrderByPostingDateDesc(userId)
						: this.jobPostDao.findByUserIdAndActiveTrueOrderByPostingDate(userId)
				: isDesc ? this.jobPostDao.findByUserIdOrderByPostingDateDesc(userId)
						: this.jobPostDao.findByUserIdOrderByPostingDate(userId), "User's All " 
				+ (isOnlyActive? "ACTIVE ": "(ACTIVE + INACTIVE) ") + "JobPosts listed! >> Ordered by " 
				+ (isDesc? "DESC." : "ASC."));
	}
}

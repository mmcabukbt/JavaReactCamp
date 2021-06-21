package kodlama.ht6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.ht6.hrms.business.abstracts.JobService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.JobDao;
import kodlama.ht6.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{
	
	private final JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<Job> add(Job job) {
		try {
			return new SuccessDataResult<Job>(this.jobDao.save(job), "This job added to database");			
		} catch (Exception e) { //Refactor this
			return new ErrorDataResult<Job>(null, "Probably UNIQUE constrain. Aynı Job zaten mevcut! HATA > " + e.getMessage());
		}
	}
	
	@Override
	public DataResult<Job> getJob(int id) {
		Job getJob = this.jobDao.getByid(id);
		return getJob == null ? new ErrorDataResult<Job>(null, "[JobService]> Job> Not found!")
				: new SuccessDataResult<Job>(getJob, "[JobService]> Job> Already exists!");
	}
	
	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "All jobs listed!");
	}

}
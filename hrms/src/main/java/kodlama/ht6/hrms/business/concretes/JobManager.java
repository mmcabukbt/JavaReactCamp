package kodlama.ht6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.ht6.hrms.business.abstracts.JobService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.JobDao;
import kodlama.ht6.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{
	
	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<Job> add(Job job) {
		return new SuccessDataResult<Job>(this.jobDao.save(job), "Bu iş, işler listesine eklendi");
	}
	
	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Tüm işler listelendi");
	}
/*
	@Override
	public List<JobPosition> getByTopCategoryId(int id) {
		return this.jobPositionDao.getByTopCategoryId(id);
	}

	@Override
	public List<JobPosition> getBySubCategoryId(int id) {
		return this.jobPositionDao.getBySubCategoryId(id);
	}//*///

	
}
package kodlama.ht6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.business.abstracts.JobPositionService;
import kodlama.ht6.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.ht6.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionDao.findAll();
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
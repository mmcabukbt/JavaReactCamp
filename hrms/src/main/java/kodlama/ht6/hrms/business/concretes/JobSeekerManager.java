package kodlama.ht6.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.business.abstracts.JobSeekerService;
import kodlama.ht6.hrms.core.entities.concretes.Claim;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.ht6.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private final JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<JobSeeker> add(JobSeeker jobSeeker) {
		List<Claim> defClaims = new ArrayList<Claim> ();
		defClaims.add(new Claim(32730)); //  Unconfirmed User
		defClaims.add(new Claim(32760)); //  Unconfirmed JobSeeker
		jobSeeker.setClaims(defClaims);		
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.save(jobSeeker), "JobSeeker successfully added");
	}
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "All JobSeekers listed.");
	}	
}

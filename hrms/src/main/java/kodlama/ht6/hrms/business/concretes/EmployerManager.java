package kodlama.ht6.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.business.abstracts.EmployerService;
import kodlama.ht6.hrms.core.entities.concretes.Claim;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.ht6.hrms.entities.concretes.Employer;
import kodlama.ht6.hrms.entities.concretes.Industry;

@Service
public class EmployerManager implements EmployerService{
	
	private final EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "All Employers listed.");
	}

	@Override
	public DataResult<Employer> add(Employer employer) {
		List<Claim> defClaims = new ArrayList<Claim> ();
		defClaims.add(new Claim((short) 32730)); //  Unconfirmed User
		defClaims.add(new Claim((short) 32750)); //  Unconfirmed Employer
		employer.setClaims(defClaims);
		employer.setSector(new Industry((short) 3));
		return new SuccessDataResult<Employer>(this.employerDao.save(employer), "Employer successfully added");
	}
}

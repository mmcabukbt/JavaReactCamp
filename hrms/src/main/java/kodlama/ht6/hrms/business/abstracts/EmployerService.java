package kodlama.ht6.hrms.business.abstracts;

import java.util.List;

import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<Employer> add(Employer employer);
	
	DataResult<List<Employer>> getAll();
}

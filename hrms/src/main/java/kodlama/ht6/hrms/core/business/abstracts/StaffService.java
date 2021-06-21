package kodlama.ht6.hrms.core.business.abstracts;

import java.util.List;

import kodlama.ht6.hrms.core.entities.concretes.Staff;
import kodlama.ht6.hrms.core.utilities.results.DataResult;

public interface StaffService {
	
	DataResult<Staff> add(Staff staff);
	
	DataResult<List<Staff>> getAll();

}

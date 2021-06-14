package kodlama.ht6.hrms.core.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.business.abstracts.StaffService;
import kodlama.ht6.hrms.core.dataAccess.abstracts.StaffDao;
import kodlama.ht6.hrms.core.entities.concretes.Staff;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;

@Service
public class StaffManager implements StaffService{
	
	private StaffDao staffDao;
	
	@Autowired
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(), "All Staffs listed.");
	}
}

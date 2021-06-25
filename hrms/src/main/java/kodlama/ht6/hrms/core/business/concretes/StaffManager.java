package kodlama.ht6.hrms.core.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.business.abstracts.StaffService;
import kodlama.ht6.hrms.core.dataAccess.abstracts.StaffDao;
import kodlama.ht6.hrms.core.entities.concretes.Claim;
import kodlama.ht6.hrms.core.entities.concretes.Staff;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.entities.concretes.Job;

@Service
public class StaffManager implements StaffService{

	private final StaffDao staffDao;
		
	@Autowired
	public StaffManager(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public  DataResult<Staff> add(Staff staff) {
		List<Claim> defClaims = new ArrayList<Claim> ();
		defClaims.add(new Claim((short) 32730)); //  Unconfirmed User
		defClaims.add(new Claim((short) 32740)); //  Unconfirmed Staff
		staff.setClaims(defClaims);
		staff.setJob(new Job((short) 1));
		return new SuccessDataResult<Staff>(this.staffDao.save(staff), "Staff successfully added");
	}
	
	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(), "All Staffs listed.");
	}
}

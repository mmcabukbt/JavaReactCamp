package kodlama.ht6.hrms.core.business.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.business.abstracts.UserService;
import kodlama.ht6.hrms.core.dataAccess.abstracts.StaffDao;
import kodlama.ht6.hrms.core.dataAccess.abstracts.UnconfirmedUserDao;
import kodlama.ht6.hrms.core.dataAccess.abstracts.UserDao;
import kodlama.ht6.hrms.core.entities.concretes.Claim;
import kodlama.ht6.hrms.core.entities.concretes.Staff;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessResult;
import kodlama.ht6.hrms.dataAccess.abstracts.CorporateDao;
import kodlama.ht6.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.ht6.hrms.dataAccess.abstracts.PersonDao;
import kodlama.ht6.hrms.entities.concretes.Corporate;
import kodlama.ht6.hrms.entities.concretes.JobSeeker;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private StaffDao staffDao;
	private PersonDao personDao;
	private JobSeekerDao jobSeekerDao;
	private CorporateDao corporateDao;
	private UnconfirmedUserDao unconfirmedUserDao;

	@Autowired
	public UserManager(UserDao userDao, StaffDao staffDao, PersonDao personDao, CorporateDao corporateDao,
			JobSeekerDao jobSeekerDao, UnconfirmedUserDao unconfirmedUserDao) {
		super();
		this.userDao = userDao;
		this.staffDao = staffDao;
		this.personDao = personDao;
		this.corporateDao = corporateDao;
		this.jobSeekerDao = jobSeekerDao;
		this.unconfirmedUserDao = unconfirmedUserDao;
	}

	@Override
	public Result addStaff(Staff staff) {
		this.staffDao.save(staff);
		UUID uuid = UUID.randomUUID();
		UnconfirmedUser unconfirmedUser = new UnconfirmedUser(staff.getId(), staff.getEmail(), uuid);
		this.unconfirmedUserDao.save(unconfirmedUser);
		return new SuccessResult( "[UserService]> Staff> Welcome! Your registration completed and confirmation email sent to: '"
					+ staff.getEmail() + "'. Please click the link to confirm and activate your membership!");
	}

	@Override
	public Result addCorporate(Corporate corporate) {
		this.corporateDao.save(corporate);
		UUID uuid = UUID.randomUUID();
		UnconfirmedUser unconfirmedUser = new UnconfirmedUser(corporate.getId(), corporate.getEmail(), uuid);
		this.unconfirmedUserDao.save(unconfirmedUser);
		return new SuccessResult("[UserService]> Corporate> Welcome! Your registration completed and confirmation email sent to: '"
					+ corporate.getEmail() + "'. Please click the link and Contact us to confirm and activate your membership!");
	}

	@Override
	public Result addJobSeeker(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		UUID uuid = UUID.randomUUID();
		UnconfirmedUser unconfirmedUser = new UnconfirmedUser(jobSeeker.getId(), jobSeeker.getEmail(), uuid);
		this.unconfirmedUserDao.save(unconfirmedUser);
		return new SuccessResult("[UserService]> JobSeeker> Welcome! Your registration completed and confirmation email sent to: '"
					+ jobSeeker.getEmail() + "'. Please click the link to confirm and activate your membership!");
	}

	@Override
	public DataResult<User> getPerson(String email, String TCkNo) {
		DataResult<User> getUserResult = this.getUser(email);
		return (getUserResult.isSuccess() || (this.personDao.getByTckNo(TCkNo) != null)) 
				? new SuccessDataResult<User>(getUserResult.getData(), "[UserService]> Person> Already exists!")
				: new ErrorDataResult<User>(null, "[UserService]> Person> Not found!");
	}

	@Override 	//Refactor this <<<<>>>><<<<<>>>>>vvvvvvvvvvvvvvvvvvvv<<<<<<<>>>>>>> 
	public DataResult<User> activateUser(UnconfirmedUser unconfirmedUser) {
		if (unconfirmedUser.getUserUuid() != null) { //POST with UUID
			UnconfirmedUser ucuserCheck = this.unconfirmedUserDao.getByUserId(unconfirmedUser.getUserId());
			if ((ucuserCheck == null) || !ucuserCheck.equals(unconfirmedUser)) {
				return new ErrorDataResult<User>(null, "[UserService]> User> Not found!"); 
			}
		}
		DataResult<User> getUserResult = this.getUser(unconfirmedUser.getEmail());
		if (!getUserResult.isSuccess()){
			return getUserResult;
		}
		if (getUserResult.getData().getId() != unconfirmedUser.getUserId()) {
			return new ErrorDataResult<User>(null, "[UserService]> User> Not found!" ); //Wrong Id but; Do not give more info!
		}
		if (getUserResult.getData().isActive()) {
			return new ErrorDataResult<User>(getUserResult.getData(), "[UserService]> User> Already Activated!");
		}
		getUserResult.getData().setActive(true);
		getUserResult.getData().getClaims().set(0, new Claim((short)(getUserResult.getData().getClaims().get(0).getId()-32700)));
		getUserResult.getData().getClaims().set(1, new Claim((short)(getUserResult.getData().getClaims().get(1).getId()-32700)));
		this.userDao.save(getUserResult.getData());
		this.unconfirmedUserDao.deleteById(getUserResult.getData().getId());
		return new SuccessDataResult<User>(getUserResult.getData(),"[UserService]> User> Activated!");
	}

	@Override
	public DataResult<User> getUser(String email) {
		User getUser = this.userDao.getByEmail(email);
		return getUser == null ? new ErrorDataResult<User>(null, "[UserService]> User> Not found!")
				: new SuccessDataResult<User>(getUser, "[UserService]> User> Already exists!");
	}
}

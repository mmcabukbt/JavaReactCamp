package kodlama.ht6.hrms.core.business.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.business.abstracts.UserService;
import kodlama.ht6.hrms.core.business.validators.userInfoValidator.UserValidatorService;
import kodlama.ht6.hrms.core.dataAccess.abstracts.UnconfirmedUserDao;
import kodlama.ht6.hrms.core.dataAccess.abstracts.UserDao;
import kodlama.ht6.hrms.core.entities.concretes.Claim;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private final UserDao userDao;
	private final UnconfirmedUserDao unconfirmedUserDao;
	private final UserValidatorService userValidatorService;

	@Autowired
	public UserManager(UserDao userDao, UnconfirmedUserDao unconfirmedUserDao, UserValidatorService userValidatorService) {
		super();
		this.userDao = userDao;
		this.unconfirmedUserDao = unconfirmedUserDao;
		this.userValidatorService = userValidatorService;
		
	}

	@Override
	public DataResult<User> getUser(String email) {
		Result emailValidating = userValidatorService.emailValidate(email);
		if (!emailValidating.isSuccess()) {
			return new ErrorDataResult<User>(null, emailValidating.getMessage());
		}
		User getUser = this.userDao.getByEmail(email);
		return getUser == null ? new ErrorDataResult<User>(null, "[UserService]> User> Not found!")
				: new SuccessDataResult<User>(getUser, "[UserService]> User> Already exists!");
	}

	@Override
	public DataResult<User> getUser(long id) {
		User getUser = this.userDao.getByid(id);
		return getUser == null ? new ErrorDataResult<User>(null, "[UserService]> User> Not found!")
				: new SuccessDataResult<User>(getUser, "[UserService]> User> Already exists!");
	}

	@Override
	public Result addUnconfirmedUser(Long uId, String email) {
		UUID uuid = UUID.randomUUID();
		UnconfirmedUser unconfirmedUser = new UnconfirmedUser(uId, email, uuid);
		this.unconfirmedUserDao.save(unconfirmedUser);
		return new SuccessResult(
				"[UserService]> User> Welcome! Your registration completed and confirmation email sent to: '"
						+ email + "'. Please click the link to confirm and activate your membership!");
	}
	
	@Override // Refactor this <<<<>>>><<<<<>>>>>vvvvvvvvvvvvvvvvvvvv<<<<<<<>>>>>>>
	public DataResult<User> activateUser(UnconfirmedUser unconfirmedUser) {
		if (unconfirmedUser.getUserUuid() != null) { // POST with UUID
			UnconfirmedUser ucUserCheck = this.unconfirmedUserDao.getByUserId(unconfirmedUser.getUserId());
			if ((ucUserCheck == null) || !ucUserCheck.equals(unconfirmedUser)) {
				return new ErrorDataResult<User>(null, "[UserService]> User> Not found!");
			}
		}
		DataResult<User> getUserResult = this.getUser(unconfirmedUser.getEmail());
		if (!getUserResult.isSuccess()) {
			return getUserResult;
		}
		if (getUserResult.getData().getId() != unconfirmedUser.getUserId()) {
			return new ErrorDataResult<User>(null, "[UserService]> User> Not found!"); // Wrong Id but; Do not give more info!
		}
		if (getUserResult.getData().isActive()) {
			return new ErrorDataResult<User>(getUserResult.getData(), "[UserService]> User> Already Activated!");
		}
		getUserResult.getData().setActive(true);
		getUserResult.getData().getClaims().set(0,
				new Claim(getUserResult.getData().getClaims().get(0).getId() - 32700));
		getUserResult.getData().getClaims().set(1,
				new Claim(getUserResult.getData().getClaims().get(1).getId() - 32700));
		this.userDao.save(getUserResult.getData());
		this.unconfirmedUserDao.deleteById(getUserResult.getData().getId());
		return new SuccessDataResult<User>(getUserResult.getData(), "[UserService]> User> Activated!");
	}


}

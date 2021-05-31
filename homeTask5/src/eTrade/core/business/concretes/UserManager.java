package eTrade.core.business.concretes;

import java.util.List;

import eTrade.core.adapters.authorizationProviderServices.AuthorizationProviderService;
import eTrade.core.adapters.confirmLinkServices.ConfirmationLinkService1;
import eTrade.core.business.abstracts.UserService;
import eTrade.core.dataAccess.abstracts.UserDao;
import eTrade.core.entities.User;
import eTrade.core.utils.results.DataResult;
import eTrade.core.utils.results.ErrorDataResult;
import eTrade.core.utils.results.Result;
import eTrade.core.validators.UserInfoValidatorService;

public class UserManager implements UserService {

	UserDao userDao;
	UserInfoValidatorService infoValidatorService;
	ConfirmationLinkService1 confirmationLinkService1;
	AuthorizationProviderService authorizationProviderService;

	public UserManager(UserDao userDao, UserInfoValidatorService infoValidatorService,
			ConfirmationLinkService1 confirmationLinkService1,
			AuthorizationProviderService authorizationProviderService) {
		this.userDao = userDao;
		this.infoValidatorService = infoValidatorService;
		this.confirmationLinkService1 = confirmationLinkService1;
		this.authorizationProviderService = authorizationProviderService;
	}

	@Override
	public Result add(User user) {
// first, info validation   ***business rules
		Result result = infoValidatorService.userInfoValidate(user);
		if (!result.isSuccess) {
			return result;
		}
// user not exist
		DataResult<User> dresult = userDao.getByEmail(user.getEmail());
		if (dresult.data != null) {
			return new ErrorDataResult<User>(user, "[UserManager]> User already exists!");
		}
// simulate sending email to confirmation link 
		System.out.println("[UserManager]> User information accepted!. Confirmation email sent to: \"" + user.getEmail()
				+ "\". Please click the link to confirm and activate your membership! ");

// link confirmation and add to db
		result = confirmationLinkService1.confirmUser(user);
		if (result.isSuccess) {
			System.out.println(result.message); //print confirmation result
			return userDao.add(user);
		} else {
			return result;
		}
	}

	@Override
	public Result addFromService() {
// just get user info, user not exist, get password  ***business rules
		DataResult<User> result = authorizationProviderService.getUserInfo();
		if (!result.isSuccess) {
			return result;
		}
		System.out.println(result.message);	//print authorization result
// user not exist
		if (userDao.getByEmail(result.data.getEmail()).data != null) {
			return new ErrorDataResult<User>(result.data, "[UserManager]> User already exists!11");
		}
// simulate to take password from user to register via AuthorizationService 
		if (takePassword() != "") {
			result.data.setPassword(takePassword());
			return userDao.add(result.data);
		} else {
			return result;
		}
	}
  	
	private String takePassword() {
		return "147258"; 		// get user's simulated password
	}

	@Override
	public Result update(User user) {
		return userDao.update(user);
	}

	@Override
	public Result delete(User user) {
		return userDao.delete(user);
	}

	@Override
	public DataResult<User> getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	@Override
	public DataResult<List<User>> getAll() {
		return userDao.getAll();
	}
}
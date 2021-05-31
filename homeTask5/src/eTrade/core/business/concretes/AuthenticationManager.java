package eTrade.core.business.concretes;

import eTrade.core.business.abstracts.AuthenticationService;
import eTrade.core.dataAccess.abstracts.UserDao;
import eTrade.core.entities.User;
import eTrade.core.utils.results.DataResult;
import eTrade.core.utils.results.ErrorDataResult;
import eTrade.core.utils.results.SuccessDataResult;

public class AuthenticationManager implements AuthenticationService {

	UserDao userDao;

	public AuthenticationManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> authenticateUser(User user) {
// user exists?
		DataResult<User> dresult = userDao.getByEmail(user.getEmail());
		if (dresult.data == null) {
			return new ErrorDataResult<User>(user, "[AuthenticationManager]> User not found!");
		}

		if (dresult.data.getPassword() == user.getPassword()) {
			return new SuccessDataResult<User>(user, "[AuthenticationManager]> User authenticated... Welcome "
					+ dresult.data.getFirstName() + " " + dresult.data.getLastName());
		}
		return new ErrorDataResult<User>(user, "[AuthenticationManager]> Invalid password, please try again!");
	}
}
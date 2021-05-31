package eTrade.core.business.abstracts;

import eTrade.core.entities.User;
import eTrade.core.utils.results.DataResult;

public interface AuthenticationService {
	public DataResult<User> authenticateUser(User user);
}
package eTrade.core.adapters.authorizationProviderServices;

import eTrade.core.entities.User;
import eTrade.core.utils.results.DataResult;

public interface AuthorizationProviderService {
	public DataResult<User> getUserInfo();
}

package eTrade.core.adapters.authorizationProviderServices.googleAuthorizationService;

import eTrade.core.adapters.authorizationProviderServices.AuthorizationProviderService;
import eTrade.core.entities.User;
import eTrade.core.utils.results.DataResult;

public interface GoogleAuthorizationService extends AuthorizationProviderService {
	public DataResult<User> getUserInfo();

}
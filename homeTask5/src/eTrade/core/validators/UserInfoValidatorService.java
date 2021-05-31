package eTrade.core.validators;

import eTrade.core.entities.User;
import eTrade.core.utils.results.Result;

public interface UserInfoValidatorService {
	Result userInfoValidate(User user);
	Result emailValidate(String email);
}

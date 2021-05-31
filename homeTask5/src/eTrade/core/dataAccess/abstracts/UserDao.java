package eTrade.core.dataAccess.abstracts;

import java.util.List;

import eTrade.core.entities.User;
import eTrade.core.utils.results.DataResult;
import eTrade.core.utils.results.Result;

public interface UserDao {
	Result add(User user);

	Result update(User user);

	Result delete(User user);

	DataResult<User> getById(int id);

	DataResult<User> getByEmail(String email);

	DataResult<List<User>> getAll();
}
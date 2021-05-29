package newestGamersCo.Abstract.OldNoNeeds;

import java.util.List;

import newestGamersCo.Entities.User;

public interface GamerService {
	
	int add(User user) throws Exception;

	void update(User user);

	void delete(User user);

	List<User> getAll();
}
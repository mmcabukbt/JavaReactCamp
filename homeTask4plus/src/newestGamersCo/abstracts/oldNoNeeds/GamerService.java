package newestGamersCo.abstracts.oldNoNeeds;

import java.util.List;

import newestGamersCo.entities.User;

public interface GamerService {
	
	int add(User user) throws Exception;

	void update(User user);

	void delete(User user);

	List<User> getAll();
}
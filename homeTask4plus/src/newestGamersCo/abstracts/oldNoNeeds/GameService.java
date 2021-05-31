package newestGamersCo.abstracts.oldNoNeeds;

import java.util.List;

import newestGamersCo.entities.Game;

public interface GameService {

	int add(Game game);

	void update(Game game);

	void delete(Game game);

	List<Game> getAll();
}
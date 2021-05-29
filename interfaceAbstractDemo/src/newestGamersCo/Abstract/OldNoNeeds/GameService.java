package newestGamersCo.Abstract.OldNoNeeds;

import java.util.List;

import newestGamersCo.Entities.Game;

public interface GameService {

	int add(Game game);

	void update(Game game);

	void delete(Game game);

	List<Game> getAll();
}
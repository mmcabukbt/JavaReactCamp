package newestGamersCo.core;

import java.util.ArrayList;
import java.util.List;

public class ManagerRepo<TEntity extends EntityRepo> implements ServiceRepo<TEntity> {

	@Override
	public void add(TEntity entity) {
		System.out.println(entity.getClass().getSimpleName() + " Added to Db.");	}

	@Override
	public void update(TEntity entity) {
		System.out.println(entity.getClass().getSimpleName() + " Updated on Db.");
	}

	@Override
	public void delete(TEntity entity) {
		System.err.println(entity.getClass().getSimpleName() + " Removed from DB!");
	}

	@Override
	public List<TEntity> getAll() {
		System.out.println("All  Listed!");
		List<TEntity> entityList = new ArrayList<>();
		return entityList; 													// Common List simulates..
	}
}
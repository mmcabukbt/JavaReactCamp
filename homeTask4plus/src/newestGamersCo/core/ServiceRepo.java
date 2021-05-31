package newestGamersCo.core;

import java.util.List;

public interface ServiceRepo<TEntity extends EntityRepo> {
	void add(TEntity entity);

	void update(TEntity entity);

	void delete(TEntity entity);

	List<TEntity> getAll();
}

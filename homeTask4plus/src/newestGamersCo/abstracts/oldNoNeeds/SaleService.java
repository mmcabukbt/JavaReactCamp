package newestGamersCo.abstracts.oldNoNeeds;

import java.util.List;

import newestGamersCo.entities.Sale;

public interface SaleService {

	void add(Sale sale);

	void update(Sale sale);

	void delete(Sale sale);

	List<Sale> getAll();
}
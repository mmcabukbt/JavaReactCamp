package newestGamersCo.Abstract.OldNoNeeds;

import java.util.List;

import newestGamersCo.Entities.Sale;

public interface SaleService {

	void add(Sale sale);

	void update(Sale sale);

	void delete(Sale sale);

	List<Sale> getAll();
}
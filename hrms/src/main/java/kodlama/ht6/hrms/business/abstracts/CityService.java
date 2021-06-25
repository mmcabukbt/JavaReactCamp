package kodlama.ht6.hrms.business.abstracts;

import java.util.List;

import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.concretes.City;

public interface CityService {
		
	DataResult<City> getById(Short id);
	
	DataResult<List<City>> getAll();
}

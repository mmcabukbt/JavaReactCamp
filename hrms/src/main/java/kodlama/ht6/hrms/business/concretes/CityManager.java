package kodlama.ht6.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.business.abstracts.CityService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.CityDao;
import kodlama.ht6.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private final CityDao cityDao;

	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "All cities listed!");
	}

	@Override
	public DataResult<City> getCity(Integer id) {
		City getCity = this.cityDao.getByid(id);
		return getCity == null ? new ErrorDataResult<City>(null, "[CityService]> City> Not found!")
				: new SuccessDataResult<City>(getCity, "[CityService]> City> Already exists!");
	}
}

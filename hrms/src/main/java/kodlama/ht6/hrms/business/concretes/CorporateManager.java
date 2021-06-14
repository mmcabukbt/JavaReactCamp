package kodlama.ht6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.business.abstracts.CorporateService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.CorporateDao;
import kodlama.ht6.hrms.entities.concretes.Corporate;

@Service
public class CorporateManager implements CorporateService{
	
	private CorporateDao corporateDao;
	
	@Autowired
	public CorporateManager(CorporateDao corporateDao) {
		super();
		this.corporateDao = corporateDao;
	}

	@Override
	public DataResult<List<Corporate>> getAll() {
		return new SuccessDataResult<List<Corporate>>(this.corporateDao.findAll(), "All Corporates listed.");
	}
}

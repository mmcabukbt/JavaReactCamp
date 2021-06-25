package kodlama.ht6.hrms.business.concretes.jsResumeBase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.business.abstracts.jsResumeBase.ForeignLanguageService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase.ForeignLanguageDao;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
	
	private final ForeignLanguageDao foreignLanguageDao;
	
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}

	@Override
	public DataResult<ForeignLanguage> getByid(Short id) {
		ForeignLanguage getLanguage = this.foreignLanguageDao.getByid(id);
		return getLanguage == null ? new ErrorDataResult<ForeignLanguage>(null, "[ForeignLanguageService]> Language> Not found!")
				: new SuccessDataResult<ForeignLanguage>(getLanguage, "[ForeignLanguageService]> Language> Already exists!");
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll(), "All foreign languages listed!");
	}
}

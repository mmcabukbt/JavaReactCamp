package kodlama.ht6.hrms.business.abstracts.jsResumeBase;

import java.util.List;

import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.ForeignLanguage;

public interface ForeignLanguageService {

	DataResult<ForeignLanguage> getByid(Short id);

	DataResult<List<ForeignLanguage>> getAll();
}

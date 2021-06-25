package kodlama.ht6.hrms.business.concretes.jsResumeBase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.business.abstracts.jsResumeBase.KnowledgeLevelService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase.KnowledgeLevelDao;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.KnowledgeLevel;

@Service
public class KnowledgeLevelManager implements KnowledgeLevelService {
	
	private final KnowledgeLevelDao knowledgeLevelDao;
	
	@Autowired
	public KnowledgeLevelManager(KnowledgeLevelDao knowledgeLevelDao) {
		super();
		this.knowledgeLevelDao = knowledgeLevelDao;
	}

	@Override
	public DataResult<KnowledgeLevel> getByid(Short id) {
		KnowledgeLevel getLanguage = this.knowledgeLevelDao.getByid(id);
		return getLanguage == null ? new ErrorDataResult<KnowledgeLevel>(null, "[KnowledgeLevelService]> KnowledgeLevel> Not found!")
				: new SuccessDataResult<KnowledgeLevel>(getLanguage, "[KnowledgeLevelService]> KnowledgeLevel> Already exists!");
	}

	@Override
	public DataResult<List<KnowledgeLevel>> getAll() {
		return new SuccessDataResult<List<KnowledgeLevel>>(this.knowledgeLevelDao.findAll(), "All KnowledgeLevels listed!");
	}
}

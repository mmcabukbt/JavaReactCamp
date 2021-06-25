package kodlama.ht6.hrms.business.abstracts.jsResumeBase;

import java.util.List;

import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.KnowledgeLevel;

public interface KnowledgeLevelService {

	DataResult<KnowledgeLevel> getByid(Short id);

	DataResult<List<KnowledgeLevel>> getAll();
}

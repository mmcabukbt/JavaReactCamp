package kodlama.ht6.hrms.business.abstracts.jsResumeBase;

import java.util.List;

import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.ProgrammingTech;

public interface ProgrammingTechService {

	DataResult<ProgrammingTech> getByid(Short id);

	DataResult<List<ProgrammingTech>> getAll();
}

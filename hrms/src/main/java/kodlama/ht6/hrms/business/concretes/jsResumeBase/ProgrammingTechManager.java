package kodlama.ht6.hrms.business.concretes.jsResumeBase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.business.abstracts.jsResumeBase.ProgrammingTechService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase.ProgrammingTechDao;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.ProgrammingTech;

@Service
public class ProgrammingTechManager implements ProgrammingTechService {
	
	private final ProgrammingTechDao programmingTechDao;
	
	@Autowired
	public ProgrammingTechManager(ProgrammingTechDao programmingTechDao) {
		super();
		this.programmingTechDao = programmingTechDao;
	}

	@Override
	public DataResult<ProgrammingTech> getByid(Short id) {
		ProgrammingTech getProgrammingTech = this.programmingTechDao.getByid(id);
		return getProgrammingTech == null ? new ErrorDataResult<ProgrammingTech>(null, "[ProgrammingTechService]> Programming & Techs> Not found!")
				: new SuccessDataResult<ProgrammingTech>(getProgrammingTech, "[ProgrammingTechService]> Programming & Techs> Already exists!");
	}

	@Override
	public DataResult<List<ProgrammingTech>> getAll() {
		return new SuccessDataResult<List<ProgrammingTech>>(this.programmingTechDao.findAll(), "All Programming & Techs listed!");
	}
}

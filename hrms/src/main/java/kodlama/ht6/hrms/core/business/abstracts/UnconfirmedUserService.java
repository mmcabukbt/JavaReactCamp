package kodlama.ht6.hrms.core.business.abstracts;

import java.util.List;


import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.utilities.results.DataResult;

public interface UnconfirmedUserService {

	DataResult<List<UnconfirmedUser>> getAll();
}

package kodlama.ht6.hrms.business.abstracts;

import java.util.List;

import kodlama.ht6.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
//	List<JobPosition> getByTopCategoryId(int id);
//	List<JobPosition> getBySubCategoryId(int id);
}

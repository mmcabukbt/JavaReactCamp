package kodlama.ht6.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
/*
	List<JobPosition> getByTopCategoryId(int id);
	List<JobPosition> getBySubCategoryId(int id);//*///
}
package kodlama.ht6.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="jobs")
public @Data class JobPosition {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="top_job_category_id")
	private int topJobCategoryId;
	
	@Column(name="sub_job_category_id")
	private int subJobCategoryId;
	
	@Column(name="job_name")
	private String jobName;

	public JobPosition() {		
	}
//*	
	public JobPosition(int id, int topJobCategoryId, int subJobCategoryId, String jobName) {
		super();
		this.id = id;
		this.topJobCategoryId = topJobCategoryId;
		this.subJobCategoryId = subJobCategoryId;
		this.jobName = jobName;
	}///*///	
}
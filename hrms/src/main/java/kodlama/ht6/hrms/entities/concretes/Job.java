package kodlama.ht6.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jobs")
public @Data class Job {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private int id;
	
	@Column(name="top_job_category_id")
	private int topJobCategoryId;
	
	@Column(name="sub_job_category_id")
	private int subJobCategoryId;

	@Column(name="job_name", unique = true)
	private String jobName;
}
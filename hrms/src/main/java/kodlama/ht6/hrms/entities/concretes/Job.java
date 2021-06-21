package kodlama.ht6.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
/*	
	@Column(name="industry_id")
	private int industryId;
//*///	
	@Column(name="sub_job_category_id")
	private int subJobCategoryId;

	@Column(name="title", unique = true)
	private String title;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="industry_id", nullable = false, updatable = false)
	private Industry industry;

	public Job(int id) {
		super();
		this.id = id;
	}
}
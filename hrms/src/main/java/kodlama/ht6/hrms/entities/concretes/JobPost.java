package kodlama.ht6.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kodlama.ht6.hrms.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_posts")
public @Data class JobPost {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
/*
	@Column(name="user_id", nullable = false)
	private long userId;
//*///
	@ManyToOne(optional = false)
	@JoinColumn(name="user_id", nullable = false, updatable = false)
	private User user;
//*///
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="min_salary", nullable = false)
	private Double minSalary;

	@Column(name="max_salary", nullable = false)
	private Double maxSalary;

	@Column(name="posting_date", nullable = false)
	private Date postingDate;

	@Column(name="closing_date", nullable = false)
	private Date closingDate;
	
	@Column(name="open_positions", nullable = false) 
	private Short openPositions;
	
	@Column(name="active", nullable = false)
	private boolean active;

	@ManyToOne(optional = false)
	@JoinColumn(name="job_id", nullable = false, updatable = false)
	private Job job;

	@ManyToOne(optional = false)
	@JoinColumn(name="city_id", nullable = false, updatable = false)
	private City city;
}
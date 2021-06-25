package kodlama.ht6.hrms.core.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlama.ht6.hrms.entities.concretes.Job;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name="staffs")
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = true)
public @Data class Staff extends Person {

	@Column(name="salary")
	private Double salary;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="job_id", nullable = false, updatable = false)
	private Job job;


	public Staff(Long id, String email, byte[] passwordHash, byte[] passwordSalt, boolean active, List<Claim> claims, 
			String tckNo, String firstName, String lastName, Short yearOfBirth, Job job, Double salary) {
		super(id, email, passwordHash, passwordSalt, active, claims, tckNo, firstName, lastName, yearOfBirth);
		this.job = job;
		this.salary = salary;
	}
}
 
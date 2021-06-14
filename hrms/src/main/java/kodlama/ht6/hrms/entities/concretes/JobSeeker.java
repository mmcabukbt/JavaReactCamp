package kodlama.ht6.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlama.ht6.hrms.core.entities.concretes.Claim;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name="jobseekers")
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = true)
public @Data class JobSeeker extends Person {

	@Column(name="jobseek_status")
	private boolean jobseekStatus;

	public JobSeeker(int id, String email, byte[] passwordHash, byte[] passwordSalt, boolean active, List<Claim> claims, 
			String tckNo, String firstName, String lastName, int yearOfBirth, boolean jobseekStatus) {
		super(id, email, passwordHash, passwordSalt, active, claims, tckNo, firstName, lastName, yearOfBirth);
		this.jobseekStatus = jobseekStatus;
	}
}
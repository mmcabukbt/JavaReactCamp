package kodlama.ht6.hrms.core.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name="persons")
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = true)
public @Data class Person extends User {
	
	@Column(name="tckno")
	private String tckNo;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="year_of_birth")
	private Short yearOfBirth;

	public Person(Long id, String email, byte[] passwordHash, byte[] passwordSalt, boolean active,
			List<Claim> claims,	String tckNo, String firstName, String lastName, Short yearOfBirth) {
		super(id, email, passwordHash, passwordSalt, active, claims);
		this.tckNo = tckNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
	}
}
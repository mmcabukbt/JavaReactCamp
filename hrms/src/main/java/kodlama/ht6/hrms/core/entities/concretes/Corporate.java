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
@Table(name="corporates")
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = true)
public @Data class Corporate extends User {

	@Column(name="name")
	private String name;

	@Column(name="website")
	private String website;
	
	@Column(name="phone")
	private String phone;

	public Corporate(long id, String email, byte[] passwordHash, byte[] passwordSalt, boolean active, List<Claim> claims,
			String name, String website, String phone) {
		super(id, email, passwordHash, passwordSalt, active, claims );
		this.name = name;
		this.website = website;
		this.phone = phone;
	}
}
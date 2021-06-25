package kodlama.ht6.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlama.ht6.hrms.core.entities.concretes.Claim;
import kodlama.ht6.hrms.core.entities.concretes.Corporate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = true)
public @Data class Employer extends Corporate {
	
	@ManyToOne(optional = false)
	@JoinColumn(name="sector_id", nullable = false, updatable = false)
	private Industry sector; //*////

	
	public Employer(Long id, String email, byte[] passwordHash, byte[] passwordSalt, boolean active, List<Claim> claims,
			String name, String website, String phone, Industry sector) {
		super(id, email, passwordHash, passwordSalt, active, claims, name, website, phone);
		this.sector = sector;
	}
}
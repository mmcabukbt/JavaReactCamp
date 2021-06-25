package kodlama.ht6.hrms.core.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_claims")
public @Data class UserClaim {
	@Id
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long userId;

	@Column(name = "claim_id")
	private Short claimId;
}

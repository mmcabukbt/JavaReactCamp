package kodlama.ht6.hrms.core.entities.concretes;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kodlama.ht6.hrms.core.entities.abstracts.User_;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="unconfirmed_users")
public @Data class UnconfirmedUser implements User_ {
	@Id
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long userId;

	@Column(name = "email")
	private String email;

	@Column(name="user_uuid")
	private UUID userUuid;
}
 
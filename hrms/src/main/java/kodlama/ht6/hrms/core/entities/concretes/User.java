package kodlama.ht6.hrms.core.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import kodlama.ht6.hrms.core.entities.abstracts.User_;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public @Data class User implements User_{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "password_hash")
	private byte[] passwordHash;

	@Column(name = "password_salt")
	private byte[] passwordSalt;
	
	@Column(name = "active")
	private boolean active;

	@ManyToMany
	@JoinTable(name = "user_claims",
		joinColumns = {	@JoinColumn (name= "user_id", referencedColumnName = "id")},
		inverseJoinColumns = { @JoinColumn(name="claim_id", referencedColumnName = "id")})
	private List<Claim> claims;
} 

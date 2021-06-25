package kodlama.ht6.hrms.entities.concretes.jsResumeBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="js_experiences")
public @Data class JsExperience {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name="resume_id", nullable = false, updatable = false)
	private Long resumeId;

	@Column(name="employer_name", nullable = false)
	private String employerName;
	
	@Column(name="department", nullable = false)
	private String department;
	
	@Column(name="starting_year", nullable = false)
	private Short startingYear;

	@Column(name="leaving_year", nullable = true)
	private Short leavingYear;
}
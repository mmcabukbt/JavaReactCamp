package kodlama.ht6.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsEducation;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsExperience;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsForeignLangKnowledge;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsProgTechKnowledge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="js_resumes")
//@JsonIgnoreProperties({"hibernateLazyInitilazer", "handler", "jsFLanguages"})
public @Data class JsResume {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
/*
	@Column(name="user_id", nullable = false)
	private Long userId;
//*///
	@ManyToOne()
	@JoinColumn(name="user_id", nullable = false, updatable = false)
	private User user;

	@Column(name="image")
	private String image;
	
	@Column(name="presentation")
	private String presentation;

	@Column(name="link_github") 
	private String linkGithub;
	
	@Column(name="link_linkedin")
	private String linkLinkedin;

	@OneToMany()
	@JoinColumn(name = "resume_id")
	private List<JsEducation> jsEducation;
	
	@OneToMany()
	@JoinColumn(name = "resume_id")
	private List<JsExperience> jsExperience; 

//	@OneToMany(mappedBy = "jsResume")
	@OneToMany()
	@JoinColumn(name = "resume_id")
	private List<JsForeignLangKnowledge> jsForeignLangKnowledge; 

	@OneToMany()
	@JoinColumn(name = "resume_id")
	private List<JsProgTechKnowledge> jsProgTechKnowledge; 
}
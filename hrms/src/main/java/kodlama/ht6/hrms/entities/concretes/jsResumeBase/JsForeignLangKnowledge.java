package kodlama.ht6.hrms.entities.concretes.jsResumeBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "js_foreign_lang_knowledges")
public @Data class JsForeignLangKnowledge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
/*
	@ManyToOne(optional = false)
	@JoinColumn(name="resume_id", nullable = false, updatable = false)
	private JsResume jsResume; //*////
	@Column(name = "resume_id", nullable = false, updatable = false)
	private Long resumeId;//*/

	@ManyToOne(optional = false)
	@JoinColumn(name="f_lang_id", nullable = false, updatable = false)
	private ForeignLanguage fLanguage;
/*	@Column(name = "f_lang_id")
	private int fLangId; //*///

	@ManyToOne(optional = false)
	@JoinColumn(name="know_lvl_id", nullable = false, updatable = false)
	private KnowledgeLevel knowledgeLevel;
}

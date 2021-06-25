package kodlama.ht6.hrms.business.concretes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kodlama.ht6.hrms.business.abstracts.JsResumeService;
import kodlama.ht6.hrms.core.business.abstracts.UserService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.dataAccess.abstracts.JsResumeDao;
import kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase.JsEducationDao;
import kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase.JsExperienceDao;
import kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase.JsForeignLangKnowledgeDao;
import kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase.JsProgTechKnowledgeDao;
import kodlama.ht6.hrms.entities.Dtos.JsResumeDto;
import kodlama.ht6.hrms.entities.Dtos.jsResumeBase.JsEducationDto;
import kodlama.ht6.hrms.entities.Dtos.jsResumeBase.JsExperienceDto;
import kodlama.ht6.hrms.entities.Dtos.jsResumeBase.Js_KnowledgeBase;
import kodlama.ht6.hrms.entities.concretes.JsResume;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.ForeignLanguage;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsEducation;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsExperience;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsForeignLangKnowledge;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsProgTechKnowledge;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.KnowledgeLevel;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.ProgrammingTech;

@Service
public class JsResumeManager implements JsResumeService {

	private final JsResumeDao jsResumeDao;
	private final JsEducationDao jsEducationDao;
	private final JsExperienceDao jsExperienceDao;
	private final JsForeignLangKnowledgeDao jsForeignLangKnowledgeDao;
	private final JsProgTechKnowledgeDao jsProgTechKnowledgeDao;
	private final UserService userService;

	@Autowired
	public JsResumeManager(JsResumeDao jsResumeDao, JsEducationDao jsEducationDao, JsExperienceDao jsExperienceDao,
			JsForeignLangKnowledgeDao jsForeignLangKnowledgeDao, JsProgTechKnowledgeDao jsProgTechKnowledgeDao,
			UserService userService) {
		super();
		this.jsResumeDao = jsResumeDao;
		this.jsEducationDao = jsEducationDao;
		this.jsExperienceDao = jsExperienceDao;
		this.jsForeignLangKnowledgeDao = jsForeignLangKnowledgeDao;
		this.jsProgTechKnowledgeDao = jsProgTechKnowledgeDao;
		this.userService = userService;
	}

	@Override // vvvvvvvvvvvvvv  Refactor this vvvvvvvvvvv
	public DataResult<JsResume> add(JsResumeDto jsResumeDto) {
		JsResume jsResume = new JsResume(0L, this.userService.getById(jsResumeDto.getUserId()).getData(),
				jsResumeDto.getImage(), jsResumeDto.getPresentation(), jsResumeDto.getLinkGithub(),
				jsResumeDto.getLinkLinkedin(), null, null, null, null);
		jsResume = this.jsResumeDao.save(jsResume);
		List<JsEducation> jsEducations = new ArrayList<JsEducation>();
		for (JsEducationDto jsEducationDto : jsResumeDto.getJsEducationsDto()) {
			jsEducations.add(new JsEducation(0L, jsResume.getId(), jsEducationDto.getSchoolName(),
					jsEducationDto.getBranch(), jsEducationDto.getStartingYear(), jsEducationDto.getFinishingYear()));
		}
		List<JsExperience> jsExperiences = new ArrayList<JsExperience>();
		for (JsExperienceDto jsExperienceDto : jsResumeDto.getJsExperiencesDto()) {
			jsExperiences.add(new JsExperience(0L, jsResume.getId(), jsExperienceDto.getEmployerName(),
					jsExperienceDto.getDepartment(), jsExperienceDto.getStartingYear(),
					jsExperienceDto.getLeavingYear()));
		}
		List<JsForeignLangKnowledge> jsForeignLangKnowledges = new ArrayList<JsForeignLangKnowledge>();
		for (Js_KnowledgeBase js_KnowledgeBase : jsResumeDto.getJsForeignLangKnowledgesDto()) {
			jsForeignLangKnowledges.add(new JsForeignLangKnowledge(0L, jsResume.getId(),
					new ForeignLanguage(js_KnowledgeBase.getKnowledgeId(), null),
					new KnowledgeLevel(js_KnowledgeBase.getKnowledgeLevelId(), null)));
		}
		List<JsProgTechKnowledge> jsProgTechKnowledges = new ArrayList<JsProgTechKnowledge>();
		for (Js_KnowledgeBase js_KnowledgeBase : jsResumeDto.getJsProgTechKnowledgesDto()) {
			jsProgTechKnowledges.add(new JsProgTechKnowledge(0L, jsResume.getId(),
					new ProgrammingTech(js_KnowledgeBase.getKnowledgeId(), null),
					new KnowledgeLevel(js_KnowledgeBase.getKnowledgeLevelId(), null)));
		}
		this.jsEducationDao.saveAll(jsEducations);
		this.jsExperienceDao.saveAll(jsExperiences);
		this.jsForeignLangKnowledgeDao.saveAll(jsForeignLangKnowledges);
		this.jsProgTechKnowledgeDao.saveAll(jsProgTechKnowledges);
		return new SuccessDataResult<JsResume>(this.jsResumeDao.save(jsResume), "Resume added!");
	}

	@Override
	public DataResult<JsResume> resumeUpdate(JsResume jsResume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<JsResume> getById(Long id) {
		JsResume getJsResume = this.jsResumeDao.getByid(id);
		return getJsResume == null ? new ErrorDataResult<JsResume>(null, "[JsResumeService]> JsResume> Not found!")
				: new SuccessDataResult<JsResume>(getJsResume, "[JsResumeService]> JsResume> Already exists!");
	}

	@Override
	public DataResult<List<JsResume>> getAll() {
		return new SuccessDataResult<List<JsResume>>(this.jsResumeDao.findAll(), "All JsResume listed!");
	}

	public DataResult<JsResumeDto> mapToJsResumeDto(String jsResumeDtoAsString) {
		JsResumeDto jsResumeDto = new JsResumeDto();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			jsResumeDto = objectMapper.readValue(jsResumeDtoAsString, JsResumeDto.class);
		} catch (IOException e) {
			return new ErrorDataResult<JsResumeDto>(null, e.getMessage());
		}
		return new SuccessDataResult<JsResumeDto>(jsResumeDto, "JsResumeDto successfull returned");
	}

	@Override
	public DataResult<List<JsEducation>> getJsEducationByResume(Long id) {
		return new SuccessDataResult<List<JsEducation>>(this.jsEducationDao.getByResumeIdOrderByStartingYearDesc(id),"");
	}

	@Override
	public DataResult<List<JsExperience>> getJsExperienceByResume(Long id) {
		return new SuccessDataResult<List<JsExperience>>(this.jsExperienceDao.getByResumeIdOrderByStartingYearDesc(id),"");
	}

	@Override
	public DataResult<List<JsProgTechKnowledge>> getByResumeIdOrderByKnowledgeLevel_idDesc_ProgTech(Long id) {
		return new SuccessDataResult<List<JsProgTechKnowledge>>(this.jsProgTechKnowledgeDao.getByResumeIdOrderByKnowledgeLevel_idDesc(id));
	}

	@Override
	public DataResult<List<JsForeignLangKnowledge>> getByResumeIdOrderByKnowledgeLevel_idDesc_FLanguage(Long id) {
		return new SuccessDataResult<List<JsForeignLangKnowledge>>(this.jsForeignLangKnowledgeDao.getByResumeIdOrderByKnowledgeLevel_idDesc(id),"");
	}

	@Override
	public DataResult<JsResume> getByIdFormatted(Long id) {
		DataResult<JsResume> getJsResume = this.getById(id);
		if (!getJsResume.isSuccess()) {
			return getJsResume;
		}
		getJsResume.getData().setJsEducation(this.getJsEducationByResume(id).getData());
		getJsResume.getData().setJsExperience(this.getJsExperienceByResume(id).getData());
		getJsResume.getData().setJsProgTechKnowledge(this.getByResumeIdOrderByKnowledgeLevel_idDesc_ProgTech(id).getData());
		getJsResume.getData().setJsForeignLangKnowledge(this.getByResumeIdOrderByKnowledgeLevel_idDesc_FLanguage(id).getData());
		return new SuccessDataResult<JsResume>(getJsResume.getData(), "[JsResumeService]> JsResume> Formatted JobSeeker's resume listed!");
	}
}

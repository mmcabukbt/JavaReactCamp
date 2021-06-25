package kodlama.ht6.hrms.api.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.ht6.hrms.business.abstracts.JsResumeService;
import kodlama.ht6.hrms.business.abstracts.jsResumeBase.ForeignLanguageService;
import kodlama.ht6.hrms.business.abstracts.jsResumeBase.KnowledgeLevelService;
import kodlama.ht6.hrms.business.abstracts.jsResumeBase.ProgrammingTechService;
import kodlama.ht6.hrms.business.adapters.CloudService;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.entities.Dtos.JsResumeDto;
import kodlama.ht6.hrms.entities.concretes.JsResume;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.ForeignLanguage;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.KnowledgeLevel;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.ProgrammingTech;

@RestController
@RequestMapping("/api/jsResumes")	
public class JsResumesController {
	
	private final CloudService cloudService;
	private final JsResumeService jsResumeService;
	private final KnowledgeLevelService knowledgeLevelService;
	private final ForeignLanguageService foreignLanguageService;
	private final ProgrammingTechService programmingTechService;
	private String imageFile;
	
	@Autowired
	public JsResumesController(CloudService cloudService, JsResumeService jsResumeService, KnowledgeLevelService knowledgeLevelService,
			ForeignLanguageService foreignLanguageService, ProgrammingTechService programmingTechService) {
		super();
		this.cloudService = cloudService;
		this.jsResumeService = jsResumeService;
		this.knowledgeLevelService = knowledgeLevelService;
		this.foreignLanguageService = foreignLanguageService;
		this.programmingTechService = programmingTechService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JsResumeDto jsResumeDto) {
		jsResumeDto.setImage(imageFile);
		return ResponseEntity.ok(this.jsResumeService.add(jsResumeDto));
	}

	@PostMapping("/addWithPhoto")
	public ResponseEntity<?> addWithPhoto(@Valid @RequestPart(value = "jsResumeDto_String") String jsResumeDtoAsString,
												 @RequestPart(value = "photo") MultipartFile photo) throws IOException {
		DataResult<JsResumeDto> result = this.jsResumeService.mapToJsResumeDto(jsResumeDtoAsString); 
		if (!result.isSuccess()) {
			return ResponseEntity.of(Optional.of(result));
		}
		@SuppressWarnings("rawtypes")
		Map uploadResult = this.cloudService.upload(photo);
		JsResumeDto jsResumeDto = result.getData();
		jsResumeDto.setImage((String) uploadResult.get("secure_url"));
		return ResponseEntity.ok(this.jsResumeService.add(jsResumeDto));
	}

	@PostMapping("/aPhotoUpload")
	public ResponseEntity<?> upload(@RequestPart MultipartFile photo) throws IOException{
		@SuppressWarnings("rawtypes")
		Map uploadResult = this.cloudService.upload(photo);
		imageFile = (String) uploadResult.get("secure_url");
		return ResponseEntity.ok(uploadResult);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JsResume>> getAll(){
		return this.jsResumeService.getAll();		
	}		

	@GetMapping("/getJsResumeById")
	public DataResult<JsResume> getJsResumeById(@RequestParam Long id) {
		return this.jsResumeService.getById(id);
	}	

	@GetMapping("/getJsResumeByIdFormatted")
	public DataResult<JsResume> getJsResumeByIdFormatted(@RequestParam Long id) {
		return this.jsResumeService.getByIdFormatted(id);
	}	
		
	@GetMapping("/getForeignLanguages")
	public DataResult<List<ForeignLanguage>> getForeignLanguages() {
		return this.foreignLanguageService.getAll();
	}

	@GetMapping("/getProgrammingTechs")
	public DataResult<List<ProgrammingTech>> getProgrammingTechs() {
		return this.programmingTechService.getAll();
	}

	@GetMapping("/getKnowledgeLevels")
	public DataResult<List<KnowledgeLevel>> getKnowledgeLevels() {
		return this.knowledgeLevelService.getAll();
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDataResult<Object> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> v_errors = new HashMap<>();
	    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
	    	v_errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
	    ErrorDataResult<Object> errors = new ErrorDataResult<Object>(v_errors,"Validation Error!"); 
	    return errors;
	}
}
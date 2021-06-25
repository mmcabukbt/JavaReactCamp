package kodlama.ht6.hrms.business.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudService {
	
	@SuppressWarnings("rawtypes")
	Map upload(MultipartFile photo) throws IOException;
}

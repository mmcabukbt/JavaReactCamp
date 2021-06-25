package kodlama.ht6.hrms.business.adapters.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager implements CloudinaryService {

	@SuppressWarnings("rawtypes")
	@Override
	public Map upload(MultipartFile photo) throws IOException {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", mycloud_name,
				"api_key", myapi_key,
				"api_secret", myapi_secret,
				"secure", true));
		return cloudinary.uploader().upload(photo.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
	}
}

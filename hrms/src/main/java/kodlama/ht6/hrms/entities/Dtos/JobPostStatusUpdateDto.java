package kodlama.ht6.hrms.entities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class JobPostStatusUpdateDto {
	
	private Long jobPostId;
	private Long userId;
	private boolean active;
}
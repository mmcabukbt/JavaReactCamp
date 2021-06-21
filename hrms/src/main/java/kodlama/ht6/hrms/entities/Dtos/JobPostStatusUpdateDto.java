package kodlama.ht6.hrms.entities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class JobPostStatusUpdateDto {
	private long jobPostId;
	private long userId;
	private boolean active;
}
package newestGamersCo.abstracts.oldNoNeeds;

import java.util.List;

import newestGamersCo.entities.Campaign;

public interface CampaignService {

	int add(Campaign campaign);

	void update(Campaign campaign);

	void delete(Campaign campaign);

	List<Campaign> getAll();
}
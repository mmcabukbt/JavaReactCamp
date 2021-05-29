package newestGamersCo.Abstract.OldNoNeeds;

import java.util.List;

import newestGamersCo.Core.EntityRepo;
import newestGamersCo.Entities.Campaign;

public interface CampaignService {

	int add(Campaign campaign);

	void update(Campaign campaign);

	void delete(Campaign campaign);

	List<Campaign> getAll();
}
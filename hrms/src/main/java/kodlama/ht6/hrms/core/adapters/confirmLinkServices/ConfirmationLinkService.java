package kodlama.ht6.hrms.core.adapters.confirmLinkServices;

import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface ConfirmationLinkService {
	public Result confirmUser(UnconfirmedUser unconfirmedUser);
}

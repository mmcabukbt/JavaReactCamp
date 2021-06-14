package kodlama.ht6.hrms.core.adapters.confirmLinkServices;

import kodlama.ht6.hrms.core.business.abstracts.UserRegistrationService;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.utilities.results.ErrorResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.results.SuccessResult;

public class ConfirmationLinkAdapter implements ConfirmationLinkService {
	
	UserRegistrationService userRegistrationService;

	public ConfirmationLinkAdapter(UserRegistrationService userRegistrationService) {
		super();
		this.userRegistrationService = userRegistrationService;
	}

	@Override
	public Result confirmUser(UnconfirmedUser unconfirmedUser) {
// Email sent to user... 
		// Sendmail(user.getEmail())
// wait 3 seconds and approve..
		try {
			System.out.println(">> Confirmation Link Service waiting..(2 seconds)..");
			Thread.sleep(1500);
			userRegistrationService.activateUser(unconfirmedUser);
			return new SuccessResult("[ConfirmationLinkService]> Approved! User clicked the link...");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			return new ErrorResult("[ConfirmationLinkService]> Could not approved : " + e.getLocalizedMessage());
		}
	}
}
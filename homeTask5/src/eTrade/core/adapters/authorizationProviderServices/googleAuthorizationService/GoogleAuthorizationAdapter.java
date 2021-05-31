package eTrade.core.adapters.authorizationProviderServices.googleAuthorizationService;

import eTrade.core.entities.User;
import eTrade.core.utils.results.DataResult;
import eTrade.core.utils.results.ErrorDataResult;
import eTrade.core.utils.results.SuccessDataResult;

public class GoogleAuthorizationAdapter implements GoogleAuthorizationService{

	private User user;
	
	public GoogleAuthorizationAdapter() {
		this.user = new User("Muhammed", "Nur", "", "nurmuhammed@gmail.com");
	}

	@Override
	public DataResult<User> getUserInfo() {
		try {
			System.out.println(">> Google Authorization Service waiting..(1 second)..");
			// wait 1 seconds and return users info without password
			Thread.sleep(1000);
			return new SuccessDataResult<User>(user, "[GoogleAuthorizationService]> Returning Google Authorization for user..");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			return new ErrorDataResult<User>(null,
					"[GoogleAuthorizationService]> Could not get User's informations :" + e.getLocalizedMessage());
		}
	}
}
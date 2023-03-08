package business.adapters;

import business.abstracts.GoogleService;
import entities.User;
import googleService.GoogleManager;

public class GoogleServiceAdapter implements GoogleService{

	@Override
	public void withGoogle(User user) {
		GoogleManager googleManager = new GoogleManager();
		googleManager.registerwithGoogle();
		
	}

}

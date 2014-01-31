package io.robusta.fora.business;

import java.util.logging.Logger;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.User;

public class UserBusiness {

	private final static Logger logger = Logger.getLogger(UserBusiness.class
			.getName());

	ForaDataSource fora = ForaDataSource.getInstance();

	public User getOrCreateUser(String email) {
		synchronized (fora) {
			for (User u : fora.getUsers()){
				if (u!=null && u.getEmail() != null && u.getEmail().equalsIgnoreCase(email)){
					return u;
				}
			}
			return createUser(email);
		}
		
		
		
	}
	
	public  User createUser(String email){
		User u = new User();
		u.setEmail(email);
		synchronized (fora) {
			u.setId((long) fora.getUsers().size());
			fora.getUsers().add(u);
		}
		
		logger.info("Created user "+email);
		return u;
	}

}

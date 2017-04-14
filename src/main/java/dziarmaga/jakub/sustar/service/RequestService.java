package dziarmaga.jakub.sustar.service;

import dziarmaga.jakub.sustar.model.User;

public interface RequestService {

	void setLoginAndToken(User user);
	void setCommand();
	void setParameter();
	void sendRequest();
	void saveRequestInFile();
}

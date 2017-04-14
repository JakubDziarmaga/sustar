package dziarmaga.jakub.sustar.service;

import dziarmaga.jakub.sustar.model.User;

public interface ResponseService {

	void createUrl(User user);
	void getResponse();
//	void showResponseInConsole();
	boolean isGameTerminated();
}


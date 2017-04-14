package dziarmaga.jakub.sustar.service;

import java.io.IOException;

import dziarmaga.jakub.sustar.model.Request;
import dziarmaga.jakub.sustar.model.Response;

public interface FileService {

	void saveRequest(Request request);
	void saveResponse(Response response);
	void closeFile() throws IOException;
}

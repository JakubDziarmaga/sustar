package dziarmaga.jakub.sustar.service;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dziarmaga.jakub.sustar.model.Request;
import dziarmaga.jakub.sustar.model.Response;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileWriter fw;
	
	@Override
	public void saveRequest(Request request) {
		
		try {
			fw.write(request.toString());
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void saveResponse(Response response){
		
		try {
			fw.write(response.toString());
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeFile() {
		
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}

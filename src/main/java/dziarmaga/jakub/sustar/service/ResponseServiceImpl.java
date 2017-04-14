package dziarmaga.jakub.sustar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import dziarmaga.jakub.sustar.model.Response;
import dziarmaga.jakub.sustar.model.User;

@Service
public class ResponseServiceImpl implements ResponseService {
	
	@Autowired
	private RestTemplate template;
	@Autowired
	private FileService fileService;
	private Response response;
	private String url;
	private int amountOfEvents;

	@Autowired
	public ResponseServiceImpl() {

		response = new Response();
		url = "http://arcology.prime.future-processing.com/describe";
		amountOfEvents = 0;
	}

	@Override
	public void createUrl(User user) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
															.queryParam("login", user.getLogin())
															.queryParam("token", user.getToken());

		url = builder.build().toUriString();
	}

	@Override
	public void getResponse() {

		try {			
			response = template.getForObject(url, Response.class);
			removeOldEvents();
			saveResponseInFile();
			showResponseInConsole();

		} catch (HttpServerErrorException e) {
			System.out.println("Wrong query");
		}
	}

	private void removeOldEvents() {

		if (response.getEvents().size() >= amountOfEvents) {
			response.getEvents().subList(0, amountOfEvents).clear();
			amountOfEvents += response.getEvents().size();
		} else // game was restarted
			amountOfEvents = response.getEvents().size();
	}
	
	private void saveResponseInFile() {

		fileService.saveResponse(response);
	}

	private void showResponseInConsole() {
		System.out.println(response.toString());
	}

	@Override
	public boolean isGameTerminated() {
		return response.getIsTerminated();
	}
}
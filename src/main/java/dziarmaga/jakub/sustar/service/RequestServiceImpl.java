package dziarmaga.jakub.sustar.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import dziarmaga.jakub.sustar.model.Request;
import dziarmaga.jakub.sustar.model.User;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	private RestTemplate template;
	@Autowired
	private FileService fileService;
	@Autowired
	private Scanner input;
	private String url;
	private Request request;

	
	public RequestServiceImpl(){
		
		request = new Request();
		url = "http://arcology.prime.future-processing.com/execute";
	}

	@Override
	public void setLoginAndToken(User user) {
		
		String login = user.getLogin();
		request.setLogin(login);
		
		String token = user.getToken();
		request.setToken(token);
	}

	@Override
	public void setCommand() {
		
		System.out.println();
		System.out.println("Command:");
		request.setCommand(input.nextLine());
	}

	@Override
	public void setParameter() {
		
		System.out.println("Parameter:");
		request.setParameter(input.nextLine());		
	}

	@Override
	public void sendRequest() {
		
		try {
			template.postForObject(url, request, Request.class);		
		} catch (HttpServerErrorException e) {
			System.out.println("Wrong query");
		}		
	}

	@Override
	public void saveRequestInFile() {
		
		fileService.saveRequest(request);		
	}
}

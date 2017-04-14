package dziarmaga.jakub.sustar;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dziarmaga.jakub.sustar.model.User;
import dziarmaga.jakub.sustar.service.FileService;
import dziarmaga.jakub.sustar.service.RequestService;
import dziarmaga.jakub.sustar.service.ResponseService;

@SpringBootApplication(scanBasePackages = "dziarmaga.jakub.sustar")
public class SustarApplication implements CommandLineRunner {

	@Autowired
	private FileService fileService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private ResponseService responseService;
	
	private User user ;
	
	private Scanner input;
	
	public static void main(String[] args)  {
		SpringApplication.run(SustarApplication.class, args);		
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		user = new User();
		input = new Scanner(System.in);
		
		setLogin(input, user);
		setToken(input, user);
		
		injectUserDataToServices();
		mainGameLoop();		
		closeFile();
	}

	private void injectUserDataToServices() {
		
		responseService.createUrl(user);
		requestService.setLoginAndToken(user);
	}
	
	private void setLogin(Scanner input, User user) {
		
		do{
		System.out.println("Login:");
		user.setLogin(input.nextLine());	
		}
		while(user.getLogin().isEmpty());
	}
	
	private void setToken(Scanner input, User user) {
		
		do{
		System.out.println("Token:");
		user.setToken(input.nextLine());
		}
		while(user.getToken().isEmpty());
	}
	
	private void mainGameLoop() {
		
		do {
			requestService.setCommand();
			requestService.setParameter();
			requestService.sendRequest();
			requestService.saveRequestInFile();
			responseService.getResponse();
		} while (!responseService.isGameTerminated());
	}

	private void closeFile() {
		
		try {
			fileService.closeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

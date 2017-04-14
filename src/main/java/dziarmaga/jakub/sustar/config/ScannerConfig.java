package dziarmaga.jakub.sustar.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScannerConfig {

	@Bean
	public Scanner inputScanner() {
		
		return new Scanner(System.in);
	}
}

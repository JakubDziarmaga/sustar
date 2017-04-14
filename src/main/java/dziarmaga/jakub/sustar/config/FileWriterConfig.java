package dziarmaga.jakub.sustar.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileWriterConfig {

	@Bean
	public FileWriter configFileWriter(){
		
        try {
    		File file=new File("Logs.txt");
			return new FileWriter(file.getAbsoluteFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

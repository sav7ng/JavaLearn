package github.aquan.springbootupload;

import github.aquan.springbootupload.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootUploadApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {

		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};

	}

}

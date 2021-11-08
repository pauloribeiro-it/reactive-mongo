package reativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories({"reativo.repository"})
public class ReactiveMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoApplication.class, args);
	}

}

package reativo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@Configuration
//@EnableMongoRepositories({"reativo.repository"})//Pode ser utilizado diretamente na repository mas deve ser
                                                //adicionado em cada repository
public class MongoDBConfig{

//    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/reactive-db");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

//    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), "reactive-db");
    }
}

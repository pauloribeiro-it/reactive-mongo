package reativo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reativo.entity.RandomNumber;

@EnableMongoRepositories
public interface RandomNumberRepository extends MongoRepository<RandomNumber, ObjectId> {
}

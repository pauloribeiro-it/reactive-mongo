package api.repository;

import api.entity.RandomNumber;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@EnableReactiveMongoRepositories
public interface RandomNumbersReactiveRepository extends ReactiveCrudRepository<RandomNumber, ObjectId> {
}

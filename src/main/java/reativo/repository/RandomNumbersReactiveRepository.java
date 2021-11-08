package reativo.repository;

import reativo.entity.RandomNumber;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@EnableReactiveMongoRepositories
public interface RandomNumbersReactiveRepository extends ReactiveCrudRepository<RandomNumber, ObjectId> {
}

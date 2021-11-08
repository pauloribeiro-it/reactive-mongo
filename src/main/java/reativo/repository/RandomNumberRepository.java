package reativo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reativo.entity.RandomNumber;

@Repository
//@EnableMongoRepositories
public interface RandomNumberRepository extends MongoRepository<RandomNumber, ObjectId> {
}

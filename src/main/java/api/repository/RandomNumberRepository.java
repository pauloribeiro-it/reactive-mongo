package api.repository;

import api.entity.RandomNumber;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomNumberRepository extends MongoRepository<RandomNumber, ObjectId> {
}

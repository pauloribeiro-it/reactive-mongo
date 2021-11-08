package reativo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reativo.repository.RandomNumberRepository;

public class RandomNumberRepositoryTest extends MongoDBIntegrationTest{

    @Autowired
    private RandomNumberRepository repository;

    @Test
    public void test_findAll(){
        Assertions.assertEquals(100, repository.findAll().size());

    }

}

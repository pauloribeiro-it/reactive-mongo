package api.service;

import api.entity.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.repository.RandomNumberRepository;
import api.repository.RandomNumbersReactiveRepository;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomNumberService {

    private final RandomNumbersReactiveRepository reactiveRepository;
    private final RandomNumberRepository repository;

    @Autowired
    public RandomNumberService(RandomNumbersReactiveRepository reactiveRepository,
                               RandomNumberRepository repository){
        this.reactiveRepository = reactiveRepository;
        this.repository = repository;
    }

    public Flux<RandomNumber> generateRandomNumbers(Long total){
        return reactiveRepository.saveAll(generateNumbers(total));
    }

    public List<RandomNumber> generateRandomNumbersBlocking(Long total){
        return repository.saveAll(generateNumbers(total));
    }

    private List<RandomNumber> generateNumbers(Long total){
        List<RandomNumber> numbers = new ArrayList<>();
        for(int i = 0; i < total; i++){
            numbers.add(new RandomNumber(new Random().nextLong()));
        }
        return numbers;
    }

}

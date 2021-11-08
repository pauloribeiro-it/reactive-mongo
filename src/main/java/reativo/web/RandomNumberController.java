package reativo.web;

import reativo.entity.RandomNumber;
import reativo.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/reativo")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    @Autowired
    public RandomNumberController(RandomNumberService randomNumberService){
        this.randomNumberService = randomNumberService;
    }

    @PostMapping("/generate-async/{total}")
    public Flux<RandomNumber> generateAsync(@PathVariable Long total){
        return randomNumberService.generateRandomNumbers(total);
    }

    @PostMapping("/generate/{total}")
    public List<RandomNumber> generate(@PathVariable Long total){
        return randomNumberService.generateRandomNumbersBlocking(total);
    }
}

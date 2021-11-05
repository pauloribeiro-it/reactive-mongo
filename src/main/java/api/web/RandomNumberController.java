package api.web;

import api.entity.RandomNumber;
import api.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    @Autowired
    public RandomNumberController(RandomNumberService randomNumberService){
        this.randomNumberService = randomNumberService;
    }

    @GetMapping("/generate-async/{total}")
    public void generateAsync(@PathVariable Long total){
        randomNumberService.generateRandomNumbers(total).subscribe();
    }

    @GetMapping("/generate/{total}")
    public void generate(@PathVariable Long total){
        randomNumberService.generateRandomNumbersBlocking(total);
    }
}

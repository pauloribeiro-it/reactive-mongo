package reativo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RandomNumber {

    @Id
    private ObjectId id;

    @Indexed
    private Long generatedNumber;

    public RandomNumber(){

    }

    public RandomNumber(Long generatedNumber){
        this.generatedNumber = generatedNumber;
    }

    public ObjectId getId() {
        return id;
    }

    public Long getGeneratedNumber() {
        return generatedNumber;
    }

    public void setGeneratedNumber(Long generatedNumber) {
        this.generatedNumber = generatedNumber;
    }
}

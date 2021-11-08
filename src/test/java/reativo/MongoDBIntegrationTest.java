package reativo;

import org.bson.BsonArray;
import org.bson.BsonDocumentReader;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public abstract class MongoDBIntegrationTest {

    @Autowired
    protected MongoTemplate mongoTemplate;

    @AfterEach
    void clean() {
        limpaRegistrosCollections();
    }

    @BeforeEach
    void setup() {
        populaCollections();
    }

    private void populaCollections() {
        final DocumentCodec codec = new DocumentCodec();
        final DecoderContext decoderContext = DecoderContext.builder().build();

        mongoTemplate.getCollectionNames().forEach(collection ->
                Optional.ofNullable(getClass().getClassLoader().getResourceAsStream(collection+".json")).ifPresent(
                        c ->{
                            try {
                                String json = obtemConteudoArquivoCollection(c);
                                BsonArray bsonArray = BsonArray.parse(json);
                                for(BsonValue bsonValue: bsonArray){
                                    Document doc = codec.decode(new BsonDocumentReader(bsonValue.asDocument()), decoderContext);
                                    mongoTemplate.getCollection(collection).insertOne(doc);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                ));
    }

    private void limpaRegistrosCollections() {
        mongoTemplate.getCollectionNames().forEach(collection ->
                mongoTemplate.getCollection(collection).deleteMany(new Document())
        );
    }

    private String obtemConteudoArquivoCollection(InputStream inputStream) throws IOException {
        final StringBuilder sb = new StringBuilder();
        try(InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){
            while(bufferedReader.ready()){
                sb.append(bufferedReader.readLine());
            }
        }
        return sb.toString();
    }
}

package alevel;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import java.util.function.Consumer;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        mongoClient.listDatabaseNames().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        MongoDatabase database = mongoClient.getDatabase("alevelDb");
        database.getCollection("users");
        for(Document document: database.getCollection("users").find()){
            System.out.println(document.toJson());
        }
        //database.createCollection("customers", null);

    }
}

package org.example;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import java.util.Arrays;

public class example1 {

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("your_database");
            MongoCollection<Document> studentsCollection = null;

            AggregateIterable<Document> avgAgePerCourse = studentsCollection.aggregate(Arrays.asList(
                    new Document("$group", new Document("_id", "$course")
                            .append("averageAge", new Document("$avg", "$age")))
            ));

            System.out.println("Average age of students in each course:");
            for (Document doc : avgAgePerCourse) {
                System.out.println(doc.get("_id") + ": " + doc.get("averageAge"));
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e);
        }
    }
}
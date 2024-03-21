package org.example.JavaAndMongo;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import java.util.Arrays;
import java.util.IllformedLocaleException;
import java.util.List;

public class ModuleStudents {
    MongoCollection<Document> mongoCollection ;
    public ModuleStudents(MongoCollection<Document> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public void addStudent(String name, int age, int studentId, List<Integer> enrolledCourse)
    {
        if(name == null || age<14||studentId<1|| enrolledCourse == null)
            throw new IllegalArgumentException("Involed argument");
        Document document = new Document("name",name)
                .append("age",age)
                .append("studentId",studentId)
                .append("e",enrolledCourse);
        mongoCollection.insertOne(document);
    }
    public void avg(MongoCollection<Document> studentsCollection){
        AggregateIterable<Document> avgAgePerCourse = studentsCollection.aggregate(Arrays.asList(
                new org.bson.Document("$group", new org.bson.Document("_id", "$course")
                        .append("averageAge", new org.bson.Document("$avg", "$age")))
        ));

         for (Document doc : avgAgePerCourse) {
            System.out.println(doc.get("_id") + ": " + doc.get("averageAge"));
        }
    }

    public void update(int studentId,List<Integer> enrollled){
        if(studentId<1 || enrollled == null){
            throw  new IllformedLocaleException();
        }
        Document query = new Document("student" ,studentId);
        Document update = new Document("$set",new Document("enrolled",enrollled));
        mongoCollection.updateOne(query,update);
    }

}

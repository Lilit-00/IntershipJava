package org.example.JavaAndMongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Base {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create("");
        MongoDatabase mongoDatabase = client.getDatabase("SchoolDB");
        MongoCollection<Document>  studentColl = craetStudentColl(mongoDatabase);
        MongoCollection<Document>  coursesColl = craetCoursesColl(mongoDatabase);
        insetStudents( studentColl);
        insetCourses(coursesColl);
    }

    private static void insetCourses(MongoCollection<Document> studentColl) {
        List<Document> courses = Arrays.asList(
                new Document("name","Lilit").append("age",23).append("studentId",1),
                new Document("name","Hayk").append("age",22).append("studentId",2),
                new Document("name","Gev").append("age",24).append("studedntId",3)
        );
        studentColl.insertMany(courses);
    }

    private static void insetStudents(MongoCollection<Document> coursesColl) {
        Document document1 = new Document("courseId", "1").append("courseName", "Mathematics").append("department", "Math");
        Document document2= new Document("courseId", "2").append("courseName", "Mathematics").append("department", "Math");
        Document document3= new Document("courseId", "3").append("courseName", "Mathematics").append("department", "Math");

        List<Document> students = new ArrayList<>();
        students.add(document1);
        students.add(document2);
        students.add(document3);
        coursesColl.insertMany(students);

    }

    private static MongoCollection<Document> craetCoursesColl(MongoDatabase mongoDatabase) {
        return mongoDatabase.getCollection("courses");
    }

    private static MongoCollection<Document> craetStudentColl(MongoDatabase mongoDatabase) {

        System.out.println("Students collection created.");
        return mongoDatabase.getCollection("student");
    }
}

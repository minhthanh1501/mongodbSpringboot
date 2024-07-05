package com.mongodb.MongodbSpring;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MongodbSpringApplicationTests {

	@Test
	void contextLoads() {
		String uri = "mongodb+srv://root:123@cluster0.asgizfq.mongodb.net/mongodbspring?retryWrites=true&w=majority&appName=Cluster0";
		try (MongoClient mongoClient = MongoClients.create(uri)) {
			MongoDatabase database = mongoClient.getDatabase("sample_mflix");
			MongoCollection<Document> collection = ((MongoDatabase) database).getCollection("users");
			Document doc = collection.find(eq("title", "Back to the Future")).first();
			if (doc != null) {
				System.out.println(doc.toJson());
			} else {
				System.out.println("No matching documents found.");
			}
		}
	}

}

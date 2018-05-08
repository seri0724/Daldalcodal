package com.daldal.springboot.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.mongodb.*;
import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.*;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;

import java.util.Arrays;
import org.bson.Document;
import org.bson.codecs.*;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.configuration.*;


@RestController
@RequestMapping(value="/api/course")
public class ApiCourseController {
	
	@Autowired
	private MongoProperties mongoproperties;
	
	@RequestMapping(value="/testtopten",method=RequestMethod.POST)
	public String testtopten(@RequestBody String position) throws JSONException {
		System.out.println("postion:"+position);
		
		MongoClient mongoClient = null;
		DB db = null;
		
		mongoClient = new MongoClient(new ServerAddress("192.168.1.28",27017));
		db = mongoClient.getDB("log");
		DBCollection collection = db.getCollection("daldalfoodstore");
		
		JSONArray monjson = new JSONArray();
		
		DBCursor cursor = collection.find().limit(60);
		
		String str = "[";
		int i = 0 ;
		
		while(cursor.hasNext()) {
			monjson.put(cursor.next());
			str += monjson.get(i) +",";
			System.out.println(monjson.get(i));
			i++;
		}
		System.out.println(str);
		str = str.substring(0, str.length()-1);
		str += "]";
		System.out.println(str);
		
		return str;
	}
	
	
	@RequestMapping(value="/topten",method=RequestMethod.POST)
	public String tenCourse(@RequestBody String position) throws JSONException {
		System.out.println("request contents:"+position);
		MongoClient mongoClient = null;
		MongoDatabase db = null;
		
		JSONArray j = new JSONArray(position);
		String lat = ((JSONObject)j.get(0)).getString("lat");
		String lng = ((JSONObject)j.get(0)).getString("lng");
		
		Double doulat = Double.parseDouble(lat);
		Double doulng = Double.parseDouble(lng);
		
		//mongodb 에서 바로 top10 뽑아오면됨
		mongoClient = new MongoClient(mongoproperties.getHost(),mongoproperties.getPort());
		db = mongoClient.getDatabase("log");
		MongoCollection<Document> collection = db.getCollection("daldalfoodstore");
		
		Position posi = new Position(doulng,doulat);
		Point place = new Point(posi);
		
		Document myDoc = collection.find().first();
		System.out.println("쿼리테스트완료"+myDoc.toJson());
		
		MongoCursor<Document> cursor2 = collection.find(
				new Document("place.position",
						new Document("$nearSphere",place)
						.append("$maxDistance", 500)
						)).iterator();
		System.out.println("쿼리완료");
		
		int cnt = 0;
		try {
			while(cursor2.hasNext()) {
				cursor2.next();
				cnt++;
			}
		} finally {
			cursor2.close();
		}
		System.out.println("cnt:"+cnt); //find size
		int[] a = new int[10];
		for(int i = 0 ; i < a.length; i++) {
			a[i] = ((int)(Math.random()*cnt)+1);
			
			for(int k = 0 ; k < i; k++) {
				if(a[i] == a[k]) {
					i--;
					break;
				}
			}
		}
		
		for(int i = 0; i < 10 ; i++) {
			System.out.println(a[i]);
		}
		
		System.out.println("--------------------------------------------");
		MongoCursor<Document> cursor = collection.find(
				new Document("place.position",
						new Document("$nearSphere",place)
						.append("$maxDistance", 500)
						)).iterator();
		System.out.println("쿼리완료");
		String str = "[";
		String temp = "";
		int cnt2 = 0 ;
		while(cursor.hasNext()) {
			temp = cursor.next().toJson();
			for(int i = 0 ; i < 10 ; i++) {
				if(a[i] == cnt2) {
					str += temp;
					str += ",";
				}
			}
			cnt2++;
		}
		str = str.substring(0, str.length()-1);
		str += "]";
		System.out.println("cnt2:"+cnt2);
		
		return str;
	}

}

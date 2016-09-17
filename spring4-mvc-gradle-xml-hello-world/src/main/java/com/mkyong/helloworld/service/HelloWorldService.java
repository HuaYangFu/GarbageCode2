package com.mkyong.helloworld.service;

import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Service
public class HelloWorldService {

    DBCollection coll;

    HelloWorldService(){


        Mongo m = new Mongo();
        DB db = m.getDB("apple");
        DBCollection coll = db.getCollection("collections");
        this.coll = coll ;


    }

	public ArrayList query() {
		DBCursor cursor = coll.find();
		ArrayList<DBObject> list = new ArrayList();
        try {

			while (cursor.hasNext()) {

				DBObject obj = cursor.next();

				list.add(obj);

			}
		} finally {
			cursor.close();
		}
		return list;
	}


    public void insert(String key, String value) {
		BasicDBObject doc = new BasicDBObject();
        doc.put(key, value);
        coll.insert(doc);
    }


    public void remove(String key, String value) {
		BasicDBObject document = new BasicDBObject();
        document.put(key, value);
        coll.remove(document);
    }

	public void updata(String key, String value,String newKey,String newValue) {

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append(newKey, newValue));
		BasicDBObject searchQuery = new BasicDBObject().append(key, value);
		coll.updateMulti(searchQuery, newDocument);
	}


}
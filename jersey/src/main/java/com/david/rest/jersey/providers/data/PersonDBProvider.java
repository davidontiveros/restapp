/**
 * 
 */
package com.david.rest.jersey.providers.data;

import com.david.rest.jersey.model.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/**
 * @author daviD
 *
 */
public class PersonDBProvider extends MongoDBProviderUtil
{
	private final static String collectionName = "persons";
	
	public PersonDBProvider() 
	{
		init();
	}
	
	public Object insert(Person person)
	{
		BasicDBObject document = new BasicDBObject();
		document.put("name", person.getName());		
		return getCollection().insert(document).getUpsertedId();
	}
	
	public void findByName(String name)
	{
		BasicDBObject document = new BasicDBObject();
		document.put("name", "David");
		DBCursor cursor = getCollection().find(document);
		while(cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
	}

	@Override
	protected String getCollectionName() 
	{
		return collectionName;
	}
}

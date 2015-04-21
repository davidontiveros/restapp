/**
 * 
 */
package com.david.rest.jersey.providers.data;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * @author daviD
 *
 */
public class MongoDBProviderUtil 
{
	private static MongoClient _mongoClient;
	//private DB _db;
	public static final String DB_NAME = "mydb";	
	//private DBCollection _dbCollection;
	
	public MongoDBProviderUtil(){}
	
	/*
	protected void init()
	{
		if(_mongoClient == null || _db == null)
		{
			try 
			{
				_mongoClient = new MongoClient( "localhost" , 27017 );
				_db = _mongoClient.getDB(DB_NAME);
			} 
			catch (UnknownHostException e) 
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		_dbCollection = _db.getCollection(getCollectionName());
	}
	*/
	
	public static MongoClient getMongoClient()
	{
		if(_mongoClient == null)
		{
			try 
			{
				_mongoClient = new MongoClient( "localhost" , 27017 );
			} 
			catch (UnknownHostException e) 
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return _mongoClient;
	}
	
	/*
	protected Set<String> getAllCollections()
	{
		return _db.getCollectionNames();
	}
	
	protected DBCollection getCollection()
	{
		return _dbCollection;
	}
	*/
}

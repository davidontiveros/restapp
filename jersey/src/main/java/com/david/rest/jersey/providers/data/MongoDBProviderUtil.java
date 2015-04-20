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
abstract class MongoDBProviderUtil 
{
	private MongoClient _mongoClient;
	private DB _db;
	private static final String DB_NAME = "mydb";	
	private DBCollection _dbCollection;
	
	public MongoDBProviderUtil(){}
	
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
	
	protected Set<String> getAllCollections()
	{
		return _db.getCollectionNames();
	}
	
	protected DBCollection getCollection()
	{
		return _dbCollection;
	}
		
	protected abstract String getCollectionName();
}

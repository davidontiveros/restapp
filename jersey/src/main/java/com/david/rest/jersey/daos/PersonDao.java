/**
 * 
 */
package com.david.rest.jersey.daos;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.david.rest.jersey.model.Person;
import com.david.rest.jersey.providers.data.MongoDBProviderUtil;
import com.mongodb.MongoClient;

/**
 * @author daviD
 *
 */
public class PersonDao extends BasicDAO<Person, String>
{
	public PersonDao() 
	{
		this(MongoDBProviderUtil.getMongoClient(), new Morphia(), MongoDBProviderUtil.DB_NAME);
	}

	protected PersonDao(MongoClient mongoClient, Morphia morphia, String dbName) 
	{
		super(mongoClient, morphia, dbName);
	}
}

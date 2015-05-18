/**
 * 
 */
package com.david.rest.jersey.daos;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.david.rest.jersey.model.Person;
import com.david.rest.jersey.model.Skill;
import com.david.rest.jersey.providers.data.MongoDBProviderUtil;
import com.mongodb.MongoClient;

/**
 * @author daviD
 *
 */
public class SkillDao extends BasicDAO<Person, String> 
{
	public SkillDao() 
	{
		this(MongoDBProviderUtil.getMongoClient(), new Morphia(), MongoDBProviderUtil.DB_NAME);
	}
	
	protected SkillDao(MongoClient mongoClient, Morphia morphia, String dbName) 
	{
		super(mongoClient, morphia, dbName);
	}
	
	public Skill findById(String id)
	{
		ObjectId _id = new ObjectId(id);
		return getDatastore().find(Skill.class).field("_id").equal(_id).get();
	}
	
	public List<Skill> findAll()
	{		
		return getDatastore().find(Skill.class).asList();
	}
}

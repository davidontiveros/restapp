/**
 * 
 */
package com.david.rest.jersey.model;

import org.bson.types.ObjectId;

/**
 * @author daviD
 *
 */
public class BaseEntity 
{
	@org.mongodb.morphia.annotations.Id
	@org.mongodb.morphia.annotations.Property("id")
    protected ObjectId id;
	
	public ObjectId getId() 
	{
        return id;
    }
 
    public void setId(ObjectId id)
    {
        this.id = id;
    }
    
    @Override
    public String toString() 
    {
    	return "id:"+this.id;
    }
 
}

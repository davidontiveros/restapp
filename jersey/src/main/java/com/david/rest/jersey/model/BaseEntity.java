/**
 * 
 */
package com.david.rest.jersey.model;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author daviD
 *
 */
public class BaseEntity 
{
	@org.mongodb.morphia.annotations.Id
	@org.mongodb.morphia.annotations.Property("id")
	@JsonIgnore
    protected ObjectId id;
	
	@JsonProperty("_id")
	private String idAsString;
	
	public ObjectId getId() 
	{
        return id;
    }
 
    public void setId(ObjectId id)
    {
        this.id = id;
    }
    
    
    public String getIdAsString()
    {
    	return this.id.toHexString();
    }
    
    public void setIdAsString(String idAsString) 
    {    	
		this.idAsString = idAsString;
		if(this.id == null)
		{
			if(!ObjectId.isValid(idAsString))
			{
				throw new IllegalArgumentException("hex id string is not a valid ObjectId.");
			}
			else
			{
				this.id = new ObjectId(idAsString);
			}
		}
	}

    
    @Override
    public String toString() 
    {
    	return "id:"+(this.idAsString != null ? this.idAsString : "null");
    }
 
}

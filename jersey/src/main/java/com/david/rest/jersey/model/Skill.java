/**
 * 
 */
package com.david.rest.jersey.model;

/**
 * @author daviD
 *
 */
@org.mongodb.morphia.annotations.Entity
public class Skill extends BaseEntity
{
	public static final Integer LOW = 1;
	public static final Integer MEDIUM = 2;
	public static final Integer HIGH = 3;
	
	private String name;
	
	public Skill() {
		// TODO Auto-generated constructor stub
	}
	
	public Skill(String name) 
	{
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}

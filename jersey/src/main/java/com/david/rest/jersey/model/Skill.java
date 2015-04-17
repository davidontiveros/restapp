/**
 * 
 */
package com.david.rest.jersey.model;

/**
 * @author daviD
 *
 */
public class Skill
{
	public static final Integer LOW = 1;
	public static final Integer MEDIUM = 2;
	public static final Integer HIGH = 3;
	
	private Integer id;
	private String name;
	
	public Skill() {
		// TODO Auto-generated constructor stub
	}
	
	public Skill(Integer id, String name) 
	{
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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

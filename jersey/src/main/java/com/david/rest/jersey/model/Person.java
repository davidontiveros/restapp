/**
 * 
 */
package com.david.rest.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * TODO: javadoc.
 * @author daviD_dev
 *
 */

@XmlRootElement(name="person")
public class Person 
{
	public static final String JSON_RESPONSE = "json/person";
	public static final String JSON_ARRAY_RESPONSE = "json/persons";
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("lastname")
	private String lastname;
	
	@JsonProperty("age")
	private int age;
	
	@JsonProperty("weight")
	double weight;
	
	public Person() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public Person(int id, String name) 
	{
		this.id = id;
		this.name = name;
	}
	
	public Person(int id, String name, String lastname, int age, double weight) 
	{
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.weight = weight;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}

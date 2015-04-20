/**
 * 
 */
package com.david.rest.jersey.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO: javadoc.
 * @author daviD_dev
 *
 */

@XmlRootElement(name="Person")
public class Person 
{
	public static final String JSON_RESPONSE = "json/person";
	public static final String JSON_ARRAY_RESPONSE = "json/persons";
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("lastname")
	private String lastname;
	
	@JsonProperty("personSkills")
	private List<PersonSkill> personSkills = new ArrayList<PersonSkill>();
	
	public Person() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public Person(int id, String name) 
	{
		this.id = id;
		this.name = name;
	}
	
	public Person(int id, String name, String lastname, List<PersonSkill> skills) 
	{
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.personSkills = skills;
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

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the skills
	 */
	public List<PersonSkill> getPersonSkills() {
		return personSkills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setPersonSkills(List<PersonSkill> skills) {
		this.personSkills = skills;
	}

	
	public void addPersonSkill(PersonSkill skill) 
	{
		this.personSkills.add(skill);
	}
}

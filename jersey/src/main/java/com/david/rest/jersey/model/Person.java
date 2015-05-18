/**
 * 
 */
package com.david.rest.jersey.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO: javadoc.
 * @author daviD_dev
 *
 */

@XmlRootElement(name="person")
@org.mongodb.morphia.annotations.Entity
public class Person extends BaseEntity
{
	public static final String JSON_RESPONSE = "json/person";
	public static final String JSON_ARRAY_RESPONSE = "json/persons";
	
	//private Integer id;
	private String name;
	private String lastname;
	
	@org.mongodb.morphia.annotations.Embedded("personSkills")
	private List<PersonSkill> personSkills = new ArrayList<PersonSkill>();
	
	public Person() 
	{
		// TODO Auto-generated constructor stub
	}
	
	/*
	public Person(int id, String name) 
	{
		this.id = id;
		this.name = name;
	}
	*/
	
	/*
	public Person(int id, String name, String lastname, List<PersonSkill> skills) 
	{
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.personSkills = skills;
	}
	*/
	
	/**
	 * @return the id
	 
	public Integer getId() {
		return id;
	}*/

	/**
	 * @param id the id to set
	 
	public void setId(Integer id) {
		this.id = id;
	}*/

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
	
	@Override
	public String toString() 
	{	
		return super.toString()+", name:"+this.name+", lastname:"+this.lastname+", skills:"+this.personSkills;
	}
}

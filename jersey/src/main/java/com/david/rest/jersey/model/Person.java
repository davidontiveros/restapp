/**
 * 
 */
package com.david.rest.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * TODO: javadoc.
 * @author daviD_dev
 *
 */

@XmlRootElement(name="person")
public class Person 
{
	public static final String JSON_RESPONSE = "json/person";
	
	@JsonProperty("id")
	int id;
	
	@JsonProperty("name")
	String name;
	
	// empty constructor needed for deserialization by JAXB
	public Person() {}

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
	
	
}

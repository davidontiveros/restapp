/**
 * 
 */
package com.david.rest.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author daviD_dev
 *
 */
@XmlRootElement
public class Person 
{
	private Integer id; 
	private String name;
	
	public Person(){}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

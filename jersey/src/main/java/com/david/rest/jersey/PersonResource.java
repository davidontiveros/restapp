/**
 * 
 */
package com.david.rest.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.david.rest.jersey.model.Person;

/**
 * @author daviD_dev
 *
 */
@Path("personService")
public class PersonResource 
{
	@Path("getPerson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson() 
	{
		Person person = new Person(); 	
		person.setId(99);
		person.setName("David");
		return person;					
	}
}

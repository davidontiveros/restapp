/**
 * 
 */
package com.david.rest.jersey.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.david.rest.jersey.model.Person;

/**
 * TODO: javadoc.
 * @author daviD_dev
 *
 */
@Path("personService")
public class PersonResource 
{
	@Path("getPerson")
	@GET
	@Produces(Person.JSON_RESPONSE)
	public Person getPerson() 
	{
		Person person = new Person(); 	
		person.setId(99);
		person.setName("David");
		return person;					
	}
		
	@Path("putPerson")
	@PUT
	@Consumes(Person.JSON_RESPONSE)
	public void insertPerson(Person person)
	{
		System.out.println("entered to put!");
	}
	
	@Path("postPerson")
	@POST
	@Consumes(Person.JSON_RESPONSE)
	public void upsertPerson(Person person)
	{
		System.out.println("entered to upsert!");
	}
	
	@Path("deletePerson")
	@DELETE
	@Consumes("")
	public void deletePerson(Person person)
	{
		System.out.println("entered to delete!");
	}
}

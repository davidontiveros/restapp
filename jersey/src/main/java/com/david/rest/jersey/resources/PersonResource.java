/**
 * 
 */
package com.david.rest.jersey.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.david.rest.jersey.controllers.Controllers;
import com.david.rest.jersey.model.Person;

/**
 * TODO: javadoc.
 * @author daviD_dev
 *
 */
@Path("personService")
public class PersonResource 
{
	@Path("getPerson/{id}")
	@GET
	@Produces(Person.JSON_RESPONSE)
	public Person getPerson(@PathParam("id") int id) 
	{
		System.out.println(id);
		Person person = Controllers.getPersonController().get(id);
		return person;
	}
	
	@Path("getPersons")
	@GET
	@Produces(Person.JSON_ARRAY_RESPONSE)
	public List<Person> getPersons() 
	{
		List<Person> list = Controllers.getPersonController().getAll();
		return list;					
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

/**
 * 
 */
package com.david.rest.jersey.providers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.david.rest.jersey.model.Person;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * @author David Ontiveros
 *
 */
@Provider
@Produces(Person.JSON_ARRAY_RESPONSE)
public class PersonsMessageBodyWriter implements MessageBodyWriter<ArrayList<Person>> 
{

	@Override
	public long getSize(ArrayList<Person> arg0, Class<?> arg1, Type arg2,
			Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) 
	{
		return type == ArrayList.class;
	}

	@Override
	public void writeTo(ArrayList<Person> persons, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException 
	{
		JacksonJsonProvider provider = new JacksonJsonProvider();		
		provider.writeTo(persons, type, genericType, annotations, mediaType, httpHeaders, entityStream);
	}

}

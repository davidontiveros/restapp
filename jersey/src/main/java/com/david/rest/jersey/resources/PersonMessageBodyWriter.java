/**
 * 
 */
package com.david.rest.jersey.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.david.rest.jersey.model.Person;

/**
 * TODO: javadoc.
 * @author daviD_dev
 *
 */
@Provider
@Produces("json/person")
public class PersonMessageBodyWriter implements MessageBodyWriter<Person>
{

	
	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) 
	{
		return type == Person.class;		
	}

	@Override
	public long getSize(Person t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) 
	{
		// deprecated by JAX-RS 2.0 and ignored by Jersey runtime
		return 0;
	}

	@Override
	public void writeTo(Person person, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException 
	{		
		// This uses the existing Jackson JSON provider to generate a JSON structure representing the Person object
		JacksonJsonProvider provider = new JacksonJsonProvider();
		provider.writeTo(person, type, genericType, annotations, mediaType, httpHeaders, entityStream);
	}

}

/**
 * 
 */
package com.david.rest.jersey.providers;

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


//import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import com.david.rest.jersey.model.Person;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * TODO: javadoc.
 * @author daviD_dev
 *
 */
@Provider
@Produces(Person.JSON_RESPONSE)
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
		/*
		  try {
	            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
	 
	            // serialize the entity myBean to the entity output stream
	            jaxbContext.createMarshaller().marshal(person, entityStream);
	        } catch (JAXBException jaxbException) {
	            throw new ProcessingException( "Error serializing a Person to the output stream", jaxbException);
	        }
		  */
		// This uses the existing Jackson JSON provider to generate a JSON structure representing the Person object
		JacksonJsonProvider provider = new JacksonJsonProvider();
		provider.writeTo(person, type, genericType, annotations, mediaType, httpHeaders, entityStream);
		
	}

}

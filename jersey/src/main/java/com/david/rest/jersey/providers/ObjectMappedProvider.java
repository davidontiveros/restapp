/**
 * 
 */
package com.david.rest.jersey.providers;

import javax.ws.rs.ext.ContextResolver;

import com.david.rest.jersey.model.Person;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

/**
 * @author daviD_dev
 *
 */
public class ObjectMappedProvider implements ContextResolver<ObjectMapper>
{
	final ObjectMapper customObjectMapper;
	final ObjectMapper defaultObjectMapper;

	public ObjectMappedProvider() 
	{   
		AnnotationIntrospector jaxbJacksonAnnotationIntrospector = createJaxbJacksonAnnotationIntrospector();
		customObjectMapper = createCustomObjectMapper(jaxbJacksonAnnotationIntrospector);
		defaultObjectMapper = createDefaultMapper();
	}
	
	@Override
	public ObjectMapper getContext(Class<?> type) 
	{
		if (type == Person.class) 
		{
            return customObjectMapper;
        } 
		else 
		{
            return defaultObjectMapper;
        }		
	}
	
	private static ObjectMapper createCustomObjectMapper(AnnotationIntrospector  combinedIntrospector) 
	{		 
		ObjectMapper result = new ObjectMapper();
		
		 result
         .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
         .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
         .setAnnotationIntrospector(combinedIntrospector);
		
		/* old code for jersey version 2.2
		result.setDeserializationConfig(result.getDeserializationConfig().withAnnotationIntrospector(combinedIntrospector));
		result.setSerializationConfig(result.getSerializationConfig().withAnnotationIntrospector(combinedIntrospector));
		*/
		
		/**
		 * Really only use this below configurations when your JSON result has the root name explicit. 
		 * IF NOT just dont used these, because by the default are FALSE.
		 */
		//result.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);		
		//result.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);		
		return result;
	}
	
	private static ObjectMapper createDefaultMapper() 
	{
        ObjectMapper result = new ObjectMapper();
        result.enable(SerializationFeature.INDENT_OUTPUT);
        return result;
    }
	
	

	private static AnnotationIntrospector createJaxbJacksonAnnotationIntrospector() 
	{
		AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
		AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
		return AnnotationIntrospector.pair(jacksonIntrospector, jaxbIntrospector);
		
		/* old code for jersey version 2.2
		AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
		AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
		return new AnnotationIntrospector.Pair(jacksonIntrospector, jaxbIntrospector);
		*/
	}
}

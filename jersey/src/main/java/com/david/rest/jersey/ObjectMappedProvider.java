/**
 * 
 */
package com.david.rest.jersey;

import javax.ws.rs.ext.ContextResolver;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.AnnotationIntrospector.Pair;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import com.david.rest.jersey.model.Person;

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
		Pair combinedIntrospector = createJaxbJacksonAnnotationIntrospector();
		customObjectMapper = createCustomObjectMapper(combinedIntrospector);
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
	
	private static ObjectMapper createCustomObjectMapper(Pair combinedIntrospector) 
	{		 
		ObjectMapper result = new ObjectMapper();
		
		result.setDeserializationConfig(result.getDeserializationConfig().withAnnotationIntrospector(combinedIntrospector));
		result.setSerializationConfig(result.getSerializationConfig().withAnnotationIntrospector(combinedIntrospector));
		
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
        result.configure(Feature.INDENT_OUTPUT, true);
        return result;
    }
	
	

	private static Pair createJaxbJacksonAnnotationIntrospector() 
	{
		AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
		AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
		return new AnnotationIntrospector.Pair(jacksonIntrospector, jaxbIntrospector);
	}
}

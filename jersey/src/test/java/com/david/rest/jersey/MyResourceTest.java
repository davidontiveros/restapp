package com.david.rest.jersey;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.david.rest.jersey.model.Person;
import com.david.rest.jersey.providers.ObjectMappedProvider;

/**
 * 
 * @author daviD_dev
 *
 */
public class MyResourceTest 
{	
    private WebTarget target;
    private static final String BASE_RESOURCE_URL = "http://localhost:8081/jersey/rest/";    
    private static final String PERSON_SERVICE_URL = "personService/";
    
    @Before
    public void setUp() throws Exception 
    {
    	// Configuration of Client, we must register Jackson feature and providers.
        ClientConfig clientConfig = new ClientConfig();              
        clientConfig.register(new JacksonFeature());
        clientConfig.register(ObjectMappedProvider.class);
        
        // Create the client and set the REST service URL
        Client client = ClientBuilder.newClient(clientConfig);
        target = client.target(URI.create(BASE_RESOURCE_URL));
        //server = HttpServer.createSimpleServer();
    }
        
    //@Test // comment this when packaging on MAVEN, because application must be ONLINE in order to receive service response. 
    public void testGetPersonResource() 
    {   
        Response response = target.path(PERSON_SERVICE_URL+"getPerson").request().get();
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());        
        Person person = target.path(PERSON_SERVICE_URL+"getPerson").request(MediaType.APPLICATION_JSON).get(Person.class);
        Assert.assertNotNull(person);
    }
}

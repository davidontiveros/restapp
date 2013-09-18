package com.david.rest.jersey;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author daviD_dev
 *
 */
public class MyResourceTest 
{	
    private WebTarget target;
    private static final String URL = "http://localhost:8089/jersey/rest/testservice/";    
    
    @Before
    public void setUp() throws Exception 
    {
        Client c = ClientBuilder.newClient();
        target = c.target(URI.create(URL));
        //server = HttpServer.createSimpleServer();
    }

    @After
    public void tearDown() throws Exception 
    {
        //server.shutdownNow();
    }
        
    @Test
    public void testResponse() 
    {       
        Response response = target.path("getItAsJSON").request().get();
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
        //Person person = target.path("getItAsJSON").request().get(Person.class);
        //Assert.assertNotNull(person);
    }
}

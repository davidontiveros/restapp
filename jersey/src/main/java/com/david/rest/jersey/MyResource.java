package com.david.rest.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * TODO: javadoc.
 * Root resource (exposed at "rest/testservice" path)
 * 
 * @author daviD_dev
 */
@Path("testService")
public class MyResource 
{
    /**
     * 
     * @return
     */
    @GET    
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() 
    {
        return "Got it!";
    }
    
    /**
     * 
     * @return
     */
    @GET    
    @Produces(MediaType.TEXT_HTML)
    public String getItAsHtml() 
    {
        return "<h2><i>Got it as HTML!</i></h2>";
    }
    
    /**
     * 
     * @return
     */
    @GET
    @Path("getXML")
    @Produces(MediaType.TEXT_XML)
    public String getItAsXml() 
    {
        return "<head>Got it as XML2!</head>";
    }
}

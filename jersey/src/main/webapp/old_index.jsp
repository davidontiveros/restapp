<!DOCTYPE html>
<html>

<header>
	<script src="js/libs/jquery-1.10.2.min.js"></script>
	<!-- <script src="js/jquery-1.10.2.min.map"></script>-->
</header>

<body>
    <h2>GET</h2>
    <p><a href="javascript:serviceDo('GET','testService','text')">getPlainText</a></p> 
    <p><a href="javascript:serviceDo('GET','testService','html')">getHTML</a></p>
    <p><a href="javascript:serviceDo('GET','testService/getXML')">getXML</a></p>
    <p><a href="javascript:serviceDo('GET','personService/getPerson')">getPerson JSON</a></p>
    
    <h2>PUT</h2>
    <p><a href="javascript:serviceDo('PUT','personService/putPerson')">putPerson</a></p>     
    
    <h2>POST</h2>
    <p><a href="javascript:serviceDo('POST','personService/postPerson')">postPerson</a></p>
    
    <h2>DELETE</h2>
    <p><a href="javascript:serviceDo('DELETE','personService/deletePerson')">deletePerson</a></p>
    
    <br>
    <div id="result"></div>
            
    <script type="text/javascript">
		/*
			Application Content Types 
		*/
		var PERSON_JSON = "json/person";
    
	 	/*
	 		JSON Object Mappings
	 	*/
	    function Person()
	    {
	    	var id;
	    	var name;
	    }	 	
    </script>
    
    <script type="text/javascript">
    	var baseURI = "http://localhost:8089/jersey/rest/";
    	
    	/*
    		ajax function that will only process GET calls.
    	*/    	   
	    function serviceDo(type, url, dataType)
	   	{   
    		alert(type);
	    	$.ajax({
	    		url: baseURI+url
	    		,type: type
	    		,dataType: dataType
	    		
	    		// ON SUCCESS
	    		,success: function(data, status, xhr)
	    		{	 	    			  
	    			var contentType = xhr.getResponseHeader("Content-Type");
	    			var result = "";
	    			
					switch(contentType)
					{									
						case PERSON_JSON:
							var person = $.extend(new Person(), data);
							result = "person.id: "+person.id +", person.name: "+person.name;
					  		break;					  	
					  	default:
					  		result = "Not custom JSON received, displaying data as it comes .. "+data;
					  		break;
					}
					
	    			$("#result").html("<b>contentType</b>: "+contentType+"<br><b>result</b>: "+result);	    			  
	    		  }
	    		  
	    		  // ON COMPLETE
	    		  ,complete: function (jqXHR, textStatus)
	    		  {
	    			  //alert(textStatus);
	    		  }
	    		  
	    		  // ON ERROR
	    		  ,error: function(jqXHR, textStatus, errorThrown)
	    		  {
	    			  alert("ERROR OCURRED! \n"+textStatus+", "+errorThrown);
		    	  }
	    		  
	    		});	    		    
	   	}
    	
	    /*
		ajax function that will only process PUT calls.
	*/    	   
    function servicePut(url, responseType)
   	{   
    	$.ajax({
    		url: baseURI+url
    		,type: "PUT"
    		,dataType: responseType
    		
    		// ON SUCCESS
    		,success: function(data, status, xhr)
    		{	 	    			  
    			var contentType = xhr.getResponseHeader("Content-Type");
    			var result = "";
    			
    			/*
				switch(contentType)
				{	
				
					case PERSON_JSON:
						var person = $.extend(new Person(), data);
						result = "person.id: "+person.id +", person.name: "+person.name;
				  		break;					  	
				  	default:
				  		result = "Not custom JSON received, displaying data as it comes .. "+data;
				  		break;
				}
    			*/
				
    			$("#result").html("<b>contentType</b>: "+contentType+"<br><b>result</b>: "+result);	    			  
    		  }
    		  
    		  // ON COMPLETE
    		  ,complete: function (jqXHR, textStatus)
    		  {
    			  //alert(textStatus);
    		  }
    		  
    		  // ON ERROR
    		  ,error: function(jqXHR, textStatus, errorThrown)
    		  {
    			  alert("ERROR OCURRED! \n"+textStatus+", "+errorThrown);
	    	  }
    		  
    		});	    		    
   	}
    </script>
</body>

</html>

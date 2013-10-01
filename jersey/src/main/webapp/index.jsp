<html>

<header>
	<script src="js/jquery-1.10.2.min.js"></script>
	<!-- <script src="js/jquery-1.10.2.min.map"></script>-->
</header>

<body>
    <h2>Jersey + Jackson</h2>
    <p><a href="javascript:onMyLinkClick('testService','text')">getPlainText</a>    
    <p><a href="javascript:onMyLinkClick('testService','html')">getHTML</a>
    <p><a href="javascript:onMyLinkClick('testService/getXML')">getXML</a>    
    <p><a href="javascript:onMyLinkClick('personService/getPerson')">getPerson JSON</a>
    
    <br>
    <div id="result"></div>
    <script type="text/javascript">
    	var baseURI = "http://localhost:8089/jersey/rest/";
	    function onMyLinkClick(url, responseType)
	   	{   
	    	$.ajax({
	    		  //type: "POST",
	    		  url: baseURI+url,
	    		  dataType: responseType,
	    		  success: function(data, status, xhr)
	    		  { 	    			  
	    			  var contentType = xhr.getResponseHeader("content-type");	    			  	    			  
	    			  $("#result").html(
	    					  "<b>contentType</b>: "+contentType
	    					  +"<br><b>data</b>: "+data);
	    			  //var person = $.extend(new Person(), data);
	    			  //alert(person.id +", "+person.name);
	    		  }
	    		});	    		    
	   	}
	    
	    
	    // JSON mappings
	    function Person()
	    {
	    	var id;
	    	var name;
	    }
    </script>
</body>

</html>

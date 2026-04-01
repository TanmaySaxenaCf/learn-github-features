Camel Project for Blueprint 
=========================================

To build this project use

    mvn install

To run the project you can execute the following Maven goal

    mvn camel:run

To deploy the project in OSGi. For example using Apache Karaf.
You can run the following command from its shell:

    osgi:install -s mvn:com.mycompany/camel-blueprint/1.0.0-SNAPSHOT

For more help see the Apache Camel documentation

    http://camel.apache.org/

    
To Invoke the service need to do following steps 
	1) features:install camel-jackson 
	
	2) copy ldap_config.xml into your karaf deploy folder
	
	3) import the OptaSingleServiceBinding MockService.xml soap project into SOAP UI
	
	4) Start the OptaSingleServiceBinding MockService service.
	
	5) use the following details to invoke the service. rtg_esb_user:aviva123
	
	6) Place the authorization_config.json,error_messages.json into following folder.
	  c:/app/opdata/properties/catalyst/fus/json/
	  
	7) Place the app_config.properties into following folder.
	  c:/app/opdata/properties/catalyst/fus/config/
	  
	8) features:install camel-cache 
	  
Note : All the json,xml and config files are available in src/test/resources  
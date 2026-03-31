fabric:container-remove-profile dev_catalyst_1 com.aviva.ca-cl_esb_fus
fabric:profile-delete com.aviva.ca-cl_esb_fus
shell:sleep 6000
fabric:profile-create --parents  karaf com.aviva.ca-cl_esb_fus	
#fabric:profile-edit  --feature cxf --feature swagger --feature fabric-cxf-registry --feature camel-jackson --feature cxf-ws-security --feature camel-cache --feature camel-cxf   com.aviva.ca-cl_esb_fus	
fabric:profile-edit  --repository mvn:com.aviva.ca/cl-esb-fus/1.0.0-SNAPSHOT/xml/features com.aviva.ca-cl_esb_fus	
fabric:profile-edit  --feature cl-esb-fus com.aviva.ca-cl_esb_fus	
fabric:container-add-profile dev_catalyst_1 com.aviva.ca-cl_esb_fus	
shell:sleep 30000

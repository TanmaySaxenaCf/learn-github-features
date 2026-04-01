/**
 * 
 */
package com.aviva.ca.esb.common.cxf.logger;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.interceptor.InterceptorProvider;

/**
 * @author tcs_2250441
 *
 */
public class CXFLoggerFeature extends AbstractFeature {
	@Override
	protected void initializeProvider(InterceptorProvider provider, Bus bus) {
		provider.getInInterceptors().add(new LoggingInInterceptor());
		provider.getOutInterceptors().add(new LoggingOutInterceptor());
		
	}
}

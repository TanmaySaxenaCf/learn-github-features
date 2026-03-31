/**
 * 
 */
package com.aviva.ca.esb.common.cxf.logger;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.cxf.common.injection.NoJSR250Annotations;
import org.apache.cxf.interceptor.AbstractLoggingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tcs_2250441
 *
 */
@NoJSR250Annotations
public class LoggingOutInterceptor extends AbstractLoggingInterceptor {
	public LoggingOutInterceptor(String phase) {
		super(phase);
		addBefore(StaxOutInterceptor.class.getName());
	}

	public LoggingOutInterceptor() {
		this(Phase.PRE_STREAM);
	}

	private static Logger LOGGER = LoggerFactory
			.getLogger(LoggingOutInterceptor.class);

	@Override
	public void handleMessage(Message message) throws Fault {
		OutputStream out = message.getContent(OutputStream.class);
		final CacheAndWriteOutputStream newOut = new CacheAndWriteOutputStream(
				out);
		message.setContent(OutputStream.class, newOut);
		newOut.registerCallback(new LoggingCallback());
	}

	public class LoggingCallback implements CachedOutputStreamCallback {

		public void onFlush(CachedOutputStream cos) {
		}

		public void onClose(CachedOutputStream cos) {

			try {
				String responseXml = getResponseToText(cos);
				LOGGER.info("[RESP]:" + responseXml);
			} catch (Exception e) {
				LOGGER.info("Error extracting Response " + e.getMessage());
			}

		}

		private String getResponseToText(CachedOutputStream cos)
				throws IOException {
			StringBuilder builder = new StringBuilder();
			limit = 209152;
			cos.writeCacheTo(builder, limit);
			String responseXml = builder.toString();
			return responseXml;
		}

	}

	@Override
	protected java.util.logging.Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}
}

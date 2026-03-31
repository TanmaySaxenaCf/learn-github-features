/**
 * 
 */
package com.aviva.ca.esb.common.cxf.logger;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.AbstractLoggingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tcs_2250441
 *
 */
public class LoggingInInterceptor extends AbstractLoggingInterceptor {

	public LoggingInInterceptor() {
		super(Phase.RECEIVE);
	}

	private static Logger LOGGER = LoggerFactory
			.getLogger(LoggingInInterceptor.class);

	@Override
	public void handleMessage(Message message) throws Fault {
		String encoding = (String) message.get(Message.ENCODING);
		LOGGER.info("[ENCODING]:" + encoding);
		String httpMethod = (String) message.get(Message.HTTP_REQUEST_METHOD);
		LOGGER.info("[HTTP_METHOD]:" + httpMethod);
		String ct = (String) message.get(Message.CONTENT_TYPE);
		LOGGER.info("[CONTENT_TYPE]:" + ct);
		Object headers = message.get(Message.PROTOCOL_HEADERS);
		LOGGER.info("[HEADERS]:" + headers);

		String uri = (String) message.get(Message.REQUEST_URL);
		if (uri == null) {
			String address = (String) message.get(Message.ENDPOINT_ADDRESS);
			uri = (String) message.get(Message.REQUEST_URI);
			if (uri != null && uri.startsWith("/")) {
				if (address != null && !address.startsWith(uri)) {
					if (address.endsWith("/") && address.length() > 1) {
						address = address.substring(0, address.length());
					}
					uri = address + uri;
				}
			} else {
				uri = address;
			}
		}
		if (uri != null) {
			LOGGER.info("[URI]:" + uri);
			String query = (String) message.get(Message.QUERY_STRING);
			if (query != null) {
				LOGGER.info("[QUERY]:" + query);
			}

		}
		String requestXml = getPayLoad(message);
		LOGGER.info("[REQUEST]:" + requestXml);
	}

	@Override
	protected java.util.logging.Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getPayLoad(Message message) {
		InputStream is = message.getContent(InputStream.class);
		String response = "";
		if (is != null) {
			CachedOutputStream bos = new CachedOutputStream();

			try {
				IOUtils.copy(is, bos);

				bos.flush();
				is.close();

				message.setContent(InputStream.class, bos.getInputStream());

				StringBuilder builder = new StringBuilder();
				bos.writeCacheTo(builder, bos.size());

				bos.close();

				response = builder.toString();

				String value = null;
				value = getFieldValue(response, "wsse:Password");
				if (null != value) {
					response = response.replace(value, "*****");
				}
			} catch (Exception e) {
				LOGGER.error("Error in extracting payload =" + e.getMessage());
			}

		}
		return response;

	}

	public String getFieldValue(String xml, String field) {
		if (!StringUtils.isEmpty(xml)) {
			Pattern pattern = Pattern.compile("<" + field + ".*?>(.*?)</"
					+ field + ">");
			Matcher matcher = pattern.matcher(xml);
			if (matcher.find()) {
				String fieldValue = null;
				fieldValue = matcher.group(0);

				if (!StringUtils.isEmpty(fieldValue)
						&& fieldValue.contains(">")
						&& fieldValue.contains("</")) {
					int beginIndex = fieldValue.indexOf(">");
					int endIndex = fieldValue.indexOf("</");
					return fieldValue.substring(beginIndex + 1, endIndex);
				}

			}
		}
		return null;
	}

	public String getTransaction(String uri, Object headers) {

		String transaction = null;
		Map<String, List<String>> map = (Map<String, List<String>>) headers;

		if (uri.contains("rest")) {
			transaction = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		} else {
			for (Entry<String, List<String>> entry : map.entrySet()) {
				if (entry.getKey().equalsIgnoreCase(("SOAPAction"))) {
					String soapAction = entry.getValue().get(0);
					transaction = soapAction.substring(
							soapAction.lastIndexOf("/") + 1,
							soapAction.length() - 1);
					break;
				}

			}
		}

		return transaction;

	}

	// Method to Mask a Field value, replacing all the characters with * except
	// the first and last character
	public String maskAllOccurrenceOfAField(String xml, String field) {
		if (!StringUtils.isEmpty(xml)) {
			Pattern pattern = Pattern.compile("<" + field + ".*?>(.*?)</"
					+ field + ">");
			Matcher matcher = pattern.matcher(xml);
			// Loop over all the occurrence
			while (matcher.find()) {
				String wordWithBraces = matcher.group(0);
				String word = matcher.group(1);
				// consider if the field value is of 2 or more characters
				if (word.length() >= 2) {
					StringBuffer convertedWord = new StringBuffer();
					convertedWord.append(word.substring(0, 1));
					for (int i = 1; i < word.length() - 1; i++) {
						convertedWord.append("*");
					}
					convertedWord.append(word.substring(word.length() - 1,
							word.length()));
					// Replace the field with masked value
					String convertedWordWithBraces = wordWithBraces.replace(
							word, convertedWord.toString());
					xml = xml.replace(wordWithBraces, convertedWordWithBraces);
				}
			}
		}
		return xml;
	}

}
package com.aviva.ca.esb.cl.opta.fus.logging;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;

public class TransactionLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionLogger.class);

	private JdbcTemplate jdbcTemplate;
	private Properties prop = new Properties();

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Method to log transaction request and response details to Data base
	 */
	@Async
	public void logPayLoad(FusTransactionLog fusTransLog) {

		String reqPayload = null;
		String resPayload = null;
		
		try {
			String sqlQuery = getSqlQuery(LoggerConstants.FUS_INSERT_TRANS_LOG);
			if (null != fusTransLog && null != sqlQuery
					&& !sqlQuery.isEmpty()) {
				
				reqPayload = null != fusTransLog.getReqPayload() ? fusTransLog.getReqPayload():null;
				resPayload = null != fusTransLog.getResPayload() ? fusTransLog.getResPayload():null;
				
				jdbcTemplate.update(
						sqlQuery,
						new Object[] { 
								
								fusTransLog.getTransactionId(),
								fusTransLog.getApplication(),
								fusTransLog.getUrl(),
								fusTransLog.getTransactionTime(),
								fusTransLog.getClientID(),
								fusTransLog.getClientName(),
								fusTransLog.getClientGUID(),
								fusTransLog.getDwellingFireProtection(),
								fusTransLog.getStreetName(),
								fusTransLog.getPostalCode(),
								fusTransLog.getMunicipality(),
								fusTransLog.getProvince(),
								reqPayload,
								resPayload,
								fusTransLog.getStatus(),
								fusTransLog.getErrorCode(),
								fusTransLog.getErrorMessage()});
			}

		} catch (Exception e) {
			LOGGER.info("Error Logging in Grey Business :", e);
		}
	}
	
	/**
	 * Method to populate transaction record details and insert into
	 * transaction_log table.
	 * 
	 * @param exchange
	 */
	public void logTransaction(Exchange exchange) {

		String transactionId = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_TRANSACTION_ID));
		String application = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_APPLICATION));
		String url = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_URL));
		String clientId = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_CLIENTID));
		String clientName = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_CLIENTNAME));
		String clientGuid = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_CLIENTGUID));
		String dwellingFireProtection = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_DWELLINGFIREPROTECTION));
		String errorCd = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_ERRORCODE));
		String errorMess = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_ERRORMESSAGE));
		Object payloadReqObj =exchange.getProperty("INITIAL_REQUEST");
		String reqPayload ="";
		if(null!=payloadReqObj){
			reqPayload =payloadReqObj instanceof String?(String)payloadReqObj:convertObjectToXml(exchange.getProperty("INITIAL_REQUEST"));
		}
		Object payloadResObj =exchange.getProperty(LoggerConstants.LOG_RESPAYLOAD);
		String resPayload ="";
		if(null!=payloadResObj){
			resPayload =payloadResObj instanceof String?(String)payloadResObj:convertObjectToXml(exchange.getProperty(LoggerConstants.LOG_RESPAYLOAD));
		}
		String status = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_STATUS));
		String municipality = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_MUNICIPALITY));
		String postalCode = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_POSTAL_CODE));
		String province = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_PROVINCE));
		String streetName = convertObjectToString(exchange.getProperty(LoggerConstants.LOG_STREET_NAME));

		FusTransactionLog transactionLog = new FusTransactionLog(transactionId,
				application, url, new Date(), clientId, clientName,
				clientGuid, dwellingFireProtection,
				streetName,postalCode,municipality,province,				
				reqPayload,resPayload,status,errorCd,errorMess);
		
		logPayLoad(transactionLog);
	}
	
	


	/**
	 * Method to get sql query for a given key
	 * 
	 * @param query_name
	 * @return String
	 * @throws Exception
	 */
	private String getSqlQuery(String query_name) throws Exception {

		try (InputStream input = getClass().getClassLoader()
				.getResourceAsStream("fus_logging_queries.properties")) {
			prop.load(input);
			return prop.getProperty(query_name);

		} catch (IOException e) {
			LOGGER.error("Unable to load fus_logging_queries.properties file "
					+ e.getMessage());
		}
		return null;
	}

	/**
	 * Method to convert object to String
	 * 
	 * @param object
	 * @return String
	 */
	private String convertObjectToString(Object object) {
		if (null != object) {
			return String.valueOf(object);
		}
		return null;
	}
	
	public static <T> String convertObjectToXml(T entity) {
		if(entity != null){
			try {
				StringWriter sw = new StringWriter();
				javax.xml.bind.JAXB.marshal(entity, sw);
				String xmlString = sw.toString();
				return xmlString;
			} catch (Exception e) {
				LOGGER.error("Unable to Marshall JAXB - Catalyst Fus", e);
				return String.valueOf(entity);
			}
		}
		return null;
	}
}

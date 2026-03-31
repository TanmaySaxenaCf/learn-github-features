package com.aviva.ca.esb.cl.opta.fus.processor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.aviva.ca.esb.cl.opta.fus.json.model.ResponseError;
import com.aviva.ca.esb.cl.opta.fus.logging.LoggerConstants;
import com.aviva.ca.esb.cl.opta.fus.model.BaseResponse;
import com.aviva.ca.esb.cl.opta.fus.model.ClientInfo;
import com.aviva.ca.esb.cl.opta.fus.model.DwellingFireProtectionResponse;
import com.aviva.ca.esb.cl.opta.fus.model.FUSResponse;
import com.aviva.ca.esb.cl.opta.fus.model.FusRequest;

import ca.optaintel.ws.optasingleservice._2.BaseProductType;
import ca.optaintel.ws.optasingleservice._2.DwellingGradesType;
import ca.optaintel.ws.optasingleservice._2.DwellingProtectedGradeType;
import ca.optaintel.ws.optasingleservice._2.FUSProductType;
import ca.optaintel.ws.optasingleservice._2.OSSResponseType;
import ca.optaintel.ws.optasingleservice._2.ProductResponseStatusType;
import ca.optaintel.ws.optasingleservice._2.ProductResultsType;
import ca.optaintel.ws.optasingleservice._2.ResultType;

public class FusAuthServiceResponseProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		OSSResponseType res = exchange.getIn().getBody(OSSResponseType.class);
		FusRequest req = (FusRequest) exchange.getProperty("INITIAL_REQUEST");
		FUSResponse finalResponse = new FUSResponse();
		/*if (null != req.getDwellingFireProtectionRequest().getFullResReq()
				&& "Y".equalsIgnoreCase(req.getDwellingFireProtectionRequest()
						.getFullResReq())) {
			finalResponse.setResponseBodyType(res.getResponseBody());
		} else if (null != req.getDwellingFireProtectionRequest()
				.getFullResReq()
				&& "N".equalsIgnoreCase(req.getDwellingFireProtectionRequest()
						.getFullResReq())) {*/
			List<ResultType> listResultType = res.getResponseBody().getResult();
			for (ResultType resultType : listResultType) {
				ProductResultsType productResultsType = resultType
						.getProductResults();
				List<BaseProductType> listProductType = new ArrayList<>();
				for (JAXBElement<?> element : productResultsType.getIClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct()) {
					if (element.getValue() instanceof BaseProductType) {
						listProductType.add((BaseProductType) element.getValue());
					}
				}
				for (BaseProductType baseProductType : listProductType) {
					if (baseProductType instanceof FUSProductType) {
						FUSProductType fusProductType = (FUSProductType) baseProductType;
						DwellingFireProtectionResponse response = new DwellingFireProtectionResponse();
						BaseResponse baseResponse = new BaseResponse();
						ClientInfo clientInfo = new ClientInfo();
						ClientInfo inputClientInfo = req.getBaseRequest().getClientInfo();
						if(null != inputClientInfo){
							clientInfo.setClientGUID(inputClientInfo.getClientGUID());	
							clientInfo.setClientID(inputClientInfo.getClientID());
							clientInfo.setClientName(inputClientInfo.getClientName());							
						}
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSSXXX");							
						clientInfo.setTransactionTime(sdf.format(Calendar.getInstance().getTime()));
						baseResponse.setClientInfo(clientInfo);
						if(null != fusProductType){
						if(null != fusProductType.getDwelling()){
							 List<String> finalMapping = mapProtectionInfo(fusProductType.getDwelling().getDwellingGrades(),exchange);
							 if(null !=finalMapping && finalMapping.size()>0){
								 if (finalMapping.size() == 1){
									 baseResponse.setSuccessful(true);
									 response.getDwellingFireProtection().addAll(finalMapping);		 
								 } else{
									 exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS3001");
									 exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, "unable to determine fire protection level since multiple grades are returned, need more information.");
									 throw new ResponseError("FS3001","unable to determine fire protection level since multiple grades are returned, need more information.");
								 }							 
							 }
						}else if(fusProductType.getStatusCode().equals(ProductResponseStatusType.FAILED)){
							exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS7001");
							exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, fusProductType.getMessages().getMessage().get(0));
							throw new ResponseError("FS7001",fusProductType.getMessages().getMessage().get(0));
						}
					}
						response.setBaseResponse(baseResponse);
						finalResponse.setDwellingFireProtectionResponse(response);
					}
				}

			//}

		}
		exchange.setProperty(LoggerConstants.LOG_STATUS, LoggerConstants.SUCCESS);
		exchange.setProperty(LoggerConstants.LOG_RESPAYLOAD, finalResponse);
		exchange.getOut().setBody(finalResponse);
	}

	private List<String> mapProtectionInfo(DwellingGradesType gradeType,Exchange exchange) {
		List<String> dwellingTypes = new ArrayList<String>();
		if (null != gradeType) {
			List<DwellingProtectedGradeType> typeList = gradeType.getFirehallProtectedGrade();
			
			
			if (null != typeList) {
				for (DwellingProtectedGradeType type: typeList) {
					String grade = type.getGrade();
					 if (null != grade
							&& ("3B".equals(grade) || "3B(L)".equals(grade)
									|| "3B(F)".equals(grade) || "3BL".equals(grade) || "3BF"
										.equals(grade))) {
						dwellingTypes.add("firehall");
					}else if (null != grade
							&& ("3BS".equals(grade) || "3B(S)".equals(grade))) {
						dwellingTypes.add("shuttletanker");
					} else if(null != grade &&("4".equals(grade))) {
						dwellingTypes.add("unprorected");
					} 
					break;
				}
				
			}
			DwellingProtectedGradeType allType = gradeType
					.getAllOtherAreasGrade();
			if (null != allType) {
				String grade = allType.getGrade();
				if (null != grade &&("5".equals(grade))) {
					dwellingTypes.add("unprorected");
				} 
			}
			List<DwellingProtectedGradeType> listOfHydrant = gradeType
					.getHydrantProtectedGrade();
			for (DwellingProtectedGradeType hydrant : listOfHydrant) {
				String grade = hydrant.getGrade();
				if (null != grade
						&& ("1".equals(grade) || "2".equals(grade) || "3A"
								.equals(grade))) {
					dwellingTypes.add("hydrant");
					break;
				}
			}
		}
		exchange.setProperty(LoggerConstants.LOG_DWELLINGFIREPROTECTION, dwellingTypes.toString());
		return dwellingTypes;
	}
}

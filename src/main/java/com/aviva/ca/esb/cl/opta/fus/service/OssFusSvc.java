package com.aviva.ca.esb.cl.opta.fus.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ca.optaintel.ws.optasingleservice._2.ResultType;

import com.aviva.ca.esb.cl.opta.fus.model.FusProductRequest;



@Path("/")
public class OssFusSvc {

	//This version only supports commPeril
    @GET
    @Path("fus/")
   	@Produces({"application/json"})
    @ApiOperation(value = "fus", notes = "Returns Fus Product Details")
    @ApiResponses(value = { @ApiResponse(code = 500, message = "Invalid value supplied"), })    
    public List<ResultType>  getFusScore(
			@BeanParam FusProductRequest fusReq){
		return null;
	}
}


package com.example.exception.exceptionmapper;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import com.example.dto.ExceptionDto;
import com.example.exception.DataNotFoundException;
import com.example.exception.exceptionjson.ExceptionJson;
import com.example.util.Message;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
	
	@Inject
	private ExceptionJson json;
	
	@Override
	public Response toResponse(DataNotFoundException exception) {
		
		ExceptionDto dto = new ExceptionDto(); 
		dto.setCode(Message.CODE_404);
		dto.setMsg(Message.EXCEPTION_1);
		
		return Response.status(Response.Status.NOT_FOUND)
				.entity(json.createExceptionJson(dto))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}

package com.example.resource;

import java.sql.SQLException;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.apache.ibatis.exceptions.PersistenceException;

import com.example.dto.SampleDto;
import com.example.exception.DataNotFoundException;
import com.example.model.Input;
import com.example.service.SampleService;

@Path("api")
@RequestScoped
public class SampleResource {
	
	@Inject
	private SampleService service;	
	
	
	@Path("getlist")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<SampleDto> getList(){
		return service.getList();
	}
	
	@Path("getbyid")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public SampleDto getById(Input input) {
		SampleDto dto = service.getById(input.getId());
		if(dto == null) {
			throw new DataNotFoundException("id:" + input.getId() + "に該当するデータは見つかりませんでした。");
		}else {
			return dto;
		}
	}
	
	@Path("psqlexception")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<SampleDto> pSqlException(){
		return service.pSqlException();
	}
	
	@Path("networkexception")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public void networkException() throws SQLException{
		try {
			throw new SQLException("Intentional network error for testing purposes", "08001");
		}catch(SQLException e) {
			throw new PersistenceException("Wrapped SQLException", e);
		}
	}
	
	@Path("nullpointerexception")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public void nullPointerException(){
		throw new NullPointerException();
	}
	
	@Path("numberformatexception")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public void numberFormatException(){
		throw new NumberFormatException();
	}
	
	@Path("otherexception")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public void otherException(){
		throw new RuntimeException();
	}

}

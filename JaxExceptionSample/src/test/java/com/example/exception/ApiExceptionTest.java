package com.example.exception;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

public class ApiExceptionTest {

	//URI定義
	private final String dataNotFoundExceptionUri = "http://localhost:8080/JaxExceptionSample/rest/api/getbyid";
	private final String pSqlExceptionUri = "http://localhost:8080/JaxExceptionSample/rest/api/psqlexception";
	private final String networkExceptionUri = "http://localhost:8080/JaxExceptionSample/rest/api/networkexception";
	private final String nullPointerExceptionUri = "http://localhost:8080/JaxExceptionSample/rest/api/nullpointerexception";
	private final String numberFormatExceptionUri = "http://localhost:8080/JaxExceptionSample/rest/api/numberformatexception";
	private final String otherExceptionUri = "http://localhost:8080/JaxExceptionSample/rest/api/otherexception";

	//パラメーター定義
	private int postId = 6;

	//DataNotFoundExceptionTest
	@Test
	public void dataNotFoundExceptionTest() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(dataNotFoundExceptionUri);

		String requestBody = "{\"id\":" + postId + "}";

		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));

		System.out.println("POST(Response Status):" + response.getStatus());
		System.out.println("POST(Response Body):" + response.readEntity(String.class));

		assertEquals(404, response.getStatus());

		response.close();
		client.close();

	}

	//PSQLExceptionTest
	@Test
	public void pSqlExceptionTest() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(pSqlExceptionUri);

		Response response = target.request(MediaType.APPLICATION_JSON).get();

		System.out.println("GET(Response Status):" + response.getStatus());
		System.out.println("GET(Response Body):" + response.readEntity(String.class));

		assertEquals(500, response.getStatus());

		response.close();
		client.close();

	}

	//NetworkExceptionTest
	@Test
	public void networkExceptionTest() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(networkExceptionUri);

		Response response = target.request(MediaType.APPLICATION_JSON).get();

		System.out.println("GET(Response Status):" + response.getStatus());
		System.out.println("GET(Response Body):" + response.readEntity(String.class));

		assertEquals(500, response.getStatus());

		response.close();
		client.close();

	}

	//NumberFormatExceptionTest
	@Test
	public void numberFormatExceptionTest() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(numberFormatExceptionUri);

		Response response = target.request(MediaType.APPLICATION_JSON).get();

		System.out.println("GET(Response Status):" + response.getStatus());
		System.out.println("GET(Response Body):" + response.readEntity(String.class));

		assertEquals(500, response.getStatus());

		response.close();
		client.close();

	}

	//NullPointerExceptionTest
	@Test
	public void nullPointerExceptionTest() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(nullPointerExceptionUri);

		Response response = target.request(MediaType.APPLICATION_JSON).get();

		System.out.println("GET(Response Status):" + response.getStatus());
		System.out.println("GET(Response Body):" + response.readEntity(String.class));

		assertEquals(500, response.getStatus());

		response.close();
		client.close();

	}

	//OtherExceptionTest
	@Test
	public void otherExceptionTest() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(otherExceptionUri);

		Response response = target.request(MediaType.APPLICATION_JSON).get();

		System.out.println("GET(Response Status):" + response.getStatus());
		System.out.println("GET(Response Body):" + response.readEntity(String.class));

		assertEquals(500, response.getStatus());

		response.close();
		client.close();

	}

}

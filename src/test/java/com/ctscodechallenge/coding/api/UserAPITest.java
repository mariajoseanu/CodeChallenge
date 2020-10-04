package com.ctscodechallenge.coding.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ctscodechallenge.coding.api.model.UserRequest;
import com.ctscodechallenge.coding.api.model.UserResponse;

/**
 * Test class to test API
 * 
 * @author anumj
 *
 */
public class UserAPITest {

	// Setting the URL provided in the question 2
	private String url = "https://reqres.in/api/users";

	private TestRestTemplate restTemplate;

	private HttpHeaders headers;

	private UserRequest userRequest;

	@Before
	public void setUp() throws Exception {
		// Initializing TestRestTemplate to invoke the service
		restTemplate = new TestRestTemplate();

		// Initializing HttpHeaders
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// setting the request body for POST request of API
		userRequest = new UserRequest("darth vader", "villain");
	}

	/**
	 * Test method for GET Request of API Checking whether the response is not null
	 * and success responses verifying the response data is present
	 */
	@Test
	public void test_GetSuccessResponse() {
		// Creating HttpEntity to set the header
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		ResponseEntity<UserResponse> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
				UserResponse.class);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getData());
		assertTrue(response.getBody().getData().size() > 1);
		assertNotNull(response.getBody().getAd());
	}

	/**
	 * Test method to check the POST request
	 */

	@Test
	public void test_PostSuccessResponse() {
		// Creating HttpEntity to set the header and body
		HttpEntity<UserRequest> httpEntity = new HttpEntity<UserRequest>(userRequest, headers);
		ResponseEntity<UserResponse> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
				UserResponse.class);
		assertNotNull(response);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getId());
		assertNotNull(response.getBody().getCreatedAt());

	}

	/**
	 * Test to check error response if request body is not present Expected -error
	 * response .API returns success response
	 */
	@Test
	public void test_PostResponse_WithoutBody() {
		// Creating HttpEntity to set the header and body
		HttpEntity<UserRequest> httpEntity = new HttpEntity<UserRequest>(null, headers);
		ResponseEntity<UserResponse> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
				UserResponse.class);
		// Expecting to see 400 error, but service always returning 201
		assertNotNull(response);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

}

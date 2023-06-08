package com.example.UserManagementClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
//import java.awt.event.ActionListener;
//import java.lang.reflect.Type;
import java.util.List;

@SpringBootApplication
public class UserManagementClientApplication {

	static RestTemplate restTemplate = new RestTemplate();
	//	@Autowired
//	@Value("${userService.baseUrl}")

private static String baseUrl = "http://localhost:8087/user/";

     static Logger logger = LoggerFactory.getLogger("UserManagementClient");


	public static void main(String[] args) {

		SpringApplication.run(UserManagementClientApplication.class, args);
	//	RestTemplate restTemplate = new RestTemplate();
		//getSingleuseExchangeMethodsOfRestTemplate();
		useExchangeMethodsOfRestTemplate();
		//client.print(responseEntity);
		

	}



	private static void print(ResponseEntity<?> responseEntity) {


		// Process the response
		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println("status Code - " + statusCode);


		String responseBody = null;
		if(responseEntity.getBody() instanceof User){
			responseBody = (responseEntity.getBody()).toString();
		}else{
			responseBody = (String) responseEntity.getBody();
		}

//		HttpHeaders responseBody =  responseEntity.getBody();
//		System.out.println("response headers - " + responseBody);

		System.out.println("response body - " + responseBody);

		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("response headers - " + responseHeaders);
	}
	private static  void useExchangeMethodsOfRestTemplate(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);



		//HttpEntity<Object> requestEntity = new HttpEntity<>(user,headers);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		getSingleuserByExchangeMethod(requestEntity);

		getListUserByExchangeMethod(requestEntity);

		User user = new User();
		user.setId(19);
		user.setFirstName("Hara");
		user.setLastName("mahadev");
		user.setName("Hara mahadev");
		user.setAddress("Pakistan");
	 requestEntity = new HttpEntity<>(user,headers);
		addUserByExchangeMethod(requestEntity);
		//HttpEntity<User> requestEntity = new HttpEntity<>(headers);
		//updateUserByExchangeMethod(requestEntity);
//
		//deleteUserByExchangeMethod(requestEntity);
	}


	//getSingleUserById Rest api endpoint
	private static void getSingleuserByExchangeMethod(HttpEntity<Object> requestEntity){
		logger.debug("Started the execution---->");
	//	HttpHeaders headers = new HttpHeaders();
	//	headers.setContentType(MediaType.APPLICATION_JSON);
	//	HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
//		logger.debug("Started the execution---->");
//		logger.debug(baseUrl);
		//logger.debug(url);

		//code for get_users By id using String.class
//		ResponseEntity<String> responseEntity =
//				restTemplate.exchange(baseUrl + "getuser/5", HttpMethod.GET, requestEntity, String.class);
		ResponseEntity<String> responseEntity =
				restTemplate.exchange( baseUrl+ "getuser/5", HttpMethod.GET, requestEntity, String.class);

		//		HttpStatus statusCode = responseEntity.getStatusCode();
//		System.out.println("status Code -" + statusCode);
//
//		String user = responseEntity.getBody();
//		System.out.println("response body - " + user) ;
//		HttpHeaders responseHeaders = responseEntity.getHeaders();
//		System.out.println("response headers -" +
//				responseHeaders);
		print(responseEntity);
System.out.println("**************************************String.class**************************************");

//or we can write directly using User Object then we need to create User dummy class
		ResponseEntity<User> responseUser =
				restTemplate.exchange(baseUrl + "getuser/5", HttpMethod.GET, requestEntity, User.class);
//		User userBody = responseUser.getBody();
//		System.out.println("response body - " + userBody);
//
//		HttpStatus statusCode1 = responseUser.getStatusCode();
//		System.out.println("status Code -" + statusCode1);

//		User user1 = responseUser.getBody();
//		System.out.println("response body - " + user1) ;
//		HttpHeaders responseHeaders1 = responseUser.getHeaders();
//		System.out.println("response headers -" +
//				responseHeaders1);
		print(responseEntity);
		System.out.println("**********************************User.class*****************************************");

	}


	//get AllUsers RestEnd point
private static void getListUserByExchangeMethod(HttpEntity<Object> requestEntity){

	ResponseEntity<String> responseEntity =
			restTemplate.exchange(baseUrl + "/getusers", HttpMethod.GET, requestEntity, String.class);

//	String user = responseEntity.getBody();
//	System.out.println("response body - " + user) ;
//
//	HttpStatus statusCode = responseEntity.getStatusCode();
//	System.out.println("status Code -" + statusCode);
//
//	HttpHeaders responseHeaders = responseEntity.getHeaders();
//	System.out.println("response headers -" +
//			responseHeaders);
	print(responseEntity);
	System.out.println("**********************************In String.class******************************************");

	ResponseEntity<List> responseEntity1 =
			restTemplate.exchange(baseUrl + "/getusers", HttpMethod.GET, requestEntity, List.class);

//	List user1 = responseEntity1.getBody();
//	System.out.println("response body - " + user1) ;
	print(responseEntity);
	System.out.println("**********************************In List.class******************************************");

}

//adduser restEndpoint
	private static void addUserByExchangeMethod(HttpEntity<Object> requestEntity) {
//		User user = new User();
//		user.setId(19);
//		user.setFirstName("Hara");
//		user.setLastName("mahadev");
//		user.setName("Hara mahadev");
//		user.setAddress("Pakistan");
	//	HttpEntity<Object> requestEntity = new HttpEntity<>(user);
		ResponseEntity<User> responseEntity = restTemplate.exchange(baseUrl + "/newUser",
				HttpMethod.POST,
				requestEntity,
				User.class);
		print(responseEntity);
		System.out.println("*****ADD*******");
	}
//update User
//	private static void updateUserByExchangeMethod(HttpEntity<Object> requestEntity) {
//
//
//		ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "/updateUser/user/17/",
//				HttpMethod.PUT,
//				requestEntity,
//				String.class);
//		print(responseEntity);
//		System.out.println("*****UPDATE*******");
//	}
//delete user
//	private static void deleteUserByExchangeMethod(HttpEntity<Object> requestEntity) {
//		ResponseEntity<User> responseEntity = restTemplate.exchange(baseUrl + "/deleteUser/16",
//				HttpMethod.DELETE,
//				requestEntity,
//				User.class);
//
//
//		print(responseEntity);
//		System.out.println("*****DELETE*******");
//	}

}

# Spring-Boot-Microservices-Communication-Example-using-RestTemplate
 we will learn how to create multiple Spring boot microservices and how to use RestTemplate class to make Synchronous communication between multiple microservices.

There are two styles of Microservices Communications:

**Synchronous Communication**

**Asynchronous Communication**

# Synchronous Communication**
In the case of Synchronous Communication, the client sends a request and waits for a response from the service. The important point here is that the protocol (HTTP/HTTPS) is synchronous and the client code can only continue its task when it receives the HTTP server response. 

For example, Microservice1 acts as a client that sends a request and waits for a response from Microservice2.

**We can use RestTemplate or WebClient or Spring Cloud Open Feign library to make a Synchronous Communication multiple microservices.**

# Asynchronous Communication

In the case of Asynchronous Communication, The client sends a request and does not wait for a response from the service. The client will continue executing its task - It doesn’t wait for the response from the service. 

**For example, Microservice1 acts as a client that sends a request and doesn't wait for a response from Microservice2.**
# https://www.javaguides.net/2022/10/spring-boot-microservices-communication-using-resttemplate.html Refer this link
We can use Message brokers such as **RabbitMQ and Apache Kafka to make Asynchronous Communication between multiple microservices.**

 
We will create and set up two Spring boot projects as two microservices in IntelliJ IDEA.


# CHECK PROJECT IN MASTER BRANCH

**we learned how to create multiple Spring boot microservices and how to use RestTemplate class to make Synchronous communication between multiple microservices.**




# UserManagementClient
It is Extension of UserManagementApp we here implementing RestTemplate methods in this application ,Kindly refer ReadMeFIle for further detaile explanation.


**In real time application we use Rest Template To communicate to differeent Services,RestTemplate Enables us Communication**

**The Main Agenda of this application we have created various rest api's of this project https://github.com/saitejesh12345/UserManagementApp and tested through swagger now we are communicating,calling Rest end points using this Template concept ,Kindly please Refer above link for previous project repo:https://github.com/saitejesh12345/UserManagementApp**

![image](https://github.com/saitejesh12345/UserManagementClient/assets/108732167/a639f83b-ebaa-4e81-bcfe-bceda84ddccf)

**1.** what is Rest Template?

![image](https://github.com/saitejesh12345/UserManagementClient/assets/108732167/5df8eaa8-7e00-4e6e-9a37-b5e58c8d3d8a)


**1.** RestTemplate it extends another class and it implements RestOperations,Rest Operations has different menthods to enables communications and Rest Template implements those methods to ENable Communication.

**2.** In **UserManagementClient class **,you can simply create an Object of RestTemplate like this

**3. static RestTemplate resttemplate = new RestTemplate();**    //create an Object of RestTemplate like this

**4. static String baseurl ="http://localhost:8087/UserManagementApp/"**   //here we give other microservices URl 

![image](https://github.com/saitejesh12345/UserManagementClient/assets/108732167/4128fd5d-91e2-4023-bc26-e215ce6336a5)


Using above Url we need to **add the controller endpoints path** we need to extend in order to fetch data or update data their own path we need to mention.

**5.** Now we need to create a **default main method for above class UserManagementClient class** **using PSVM** from this main method we are going to call

![image](https://github.com/saitejesh12345/UserManagementClient/assets/108732167/70dfa635-1303-407e-ad48-2e6e1ffc1e6e)


**useExchangeMethodsOfRestTemplate();**  this contains a logic which going to interact with 3rd services.In Real time production project we will make 

**Config** class we will create RestTemplate method in that. But as of now follow same.


**6.	Focus on this line Response restTemplate as exchange Method(),go and check exchangemethod() implementation.**


..........................................................................................................

**Template :-**

public <T> ResponseEntity<T> exchange(String url, HttpMethod method,
			@Nullable HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables)
			throws RestClientException {


......................................................................................................................


Entity<User> responseEntity = restTemplate.
				exchange(baseurl + "user/5", HttpMethod.GET,requestEntity,String.class);

..............................................................................................................................


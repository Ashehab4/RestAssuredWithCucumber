package stepDefs;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CRUDStepDefs {
	
	Response response;
	RequestSpecification request;
	Map<String,Object> MapObj;
	Map<String,Object> MapObjEmployee;
	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
	    // Write code here that turns the phrase above into concrete actions
	   request = RestAssured.given().baseUri(URI);
	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
	    // Write code here that turns the phrase above into concrete actions
		response = request.get();
	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponseCode) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(expResponseCode, response.getStatusCode());
	   
	}
	
	@When("I perform the Post Operation {string} , {string} {string}")
	public void i_perform_the_Post_Operation(String Ename, String Etitle, int Esalary) {
	    // Write code here that turns the phrase above into concrete actions
		 response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "    \"name\": Ename,\r\n"
						+ "    \"title\": Etitle,\r\n"
						+ "    \"salary\": Esalary\r\n"
						+ "}")
				.post("employees/create");
	}
	

	@When("I pass name {string} , title {string} , salary {int}")
	public void i_pass_Name_Title_and_Salary(String Ename, String Etitle, int Esalary) {
	    // Write code here that turns the phrase above into concrete actions
		MapObjEmployee = new HashMap<String,Object>();
	 	
		MapObjEmployee.put("name", Ename);
		MapObjEmployee.put("title", Etitle);
		MapObjEmployee.put("salary", Esalary);
	}
	
	@When("I pass title {string} , author {string}")
	public void i_pass_title_author(String title, String author) {
	    // Write code here that turns the phrase above into concrete actions
		 MapObj = new HashMap<String,Object>();
		 	
			
			MapObj.put("title", title);
			MapObj.put("author", author);
	}
	@When("I perform the Post Operation for Posts")
	public void i_perform_the_Post_Operation_for_Posts() {
	    // Write code here that turns the phrase above into concrete actions
		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(MapObj)
				.post();

	}
	@When("I perform the Post Operation")
	public void i_perform_the_Post_Operation() {
	    // Write code here that turns the phrase above into concrete actions
		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(MapObjEmployee)
				.post();

	}
	




}

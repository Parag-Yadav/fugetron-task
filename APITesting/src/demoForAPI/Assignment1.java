 package demoForAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import static io.restassured.RestAssured.* ;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://www.boredapi.com/api/activity";
		String getUserResponse=given()
				.when().get()
				.then().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(getUserResponse);
		
	

}
}

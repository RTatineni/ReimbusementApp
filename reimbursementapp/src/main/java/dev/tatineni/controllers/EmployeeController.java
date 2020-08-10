package dev.tatineni.controllers;

import org.eclipse.jetty.client.api.Response;

import com.google.gson.Gson;

import dev.tatineni.entities.Employee;
import dev.tatineni.services.EmployeeService;
import dev.tatineni.services.EmployeeServiceImpl;
import io.javalin.http.Handler;




public class EmployeeController {

	private static EmployeeService empServ = new EmployeeServiceImpl();
	private static Gson gson = new Gson();
	
	public static Handler createEmployee = (ctx)->{
		String EmployeeJson = ctx.body();
		Employee employee = gson.fromJson(EmployeeJson, Employee.class); // transform the json into a Shcool object
		empServ.createEmployee(employee);
		ctx.status(201); // 201 is the status code to return if you successfully add something
		
		//usually you want to return the created object
		ctx.result(gson.toJson(employee));
	};
	
	
	public static Handler loginEmployee = (ctx)->{
		
		// Get user name and password from request parameters
		
		String username = ctx.pathParam("username");
		String password = ctx.pathParam("password");
		
		// Pass parameters into loginEmployee service
		int loginStatus = empServ.loginEmployee(username, password);
		if(loginStatus > 0) {
			ctx.status(200);
			ctx.result(gson.toJson(loginStatus));
			
		}
		else {
			
			ctx.status(404);
		
		}
		// Send 200 if login is successful
		
	};
	
	
	public static Handler loginEmployeeManager = (ctx)-> {
		
		String username = ctx.pathParam("username");
		String password = ctx.pathParam("password");
		
		boolean loginStatus = empServ.loginEmployeeManager(username,password);
		
		if(loginStatus == true) {
			ctx.status(200);
			ctx.result(gson.toJson(loginStatus));

		}
		else {
			ctx.status(404);

		}
	};

}










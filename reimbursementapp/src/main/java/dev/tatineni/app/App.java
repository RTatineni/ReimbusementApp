package dev.tatineni.app;

import dev.tatineni.controllers.EmployeeController;
import dev.tatineni.controllers.ReimbursementController;
import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {
		
		
		
		Javalin app = Javalin.create(config ->{    
			
			config.addStaticFiles("/frontend");
			
		}).start(7000);
		
		
	
		/* Employee End points */
		app.post("/employees", EmployeeController.createEmployee);
		app.get("/login/:username/:password",EmployeeController.loginEmployee);
		app.get("/login/manager/:username/:password", EmployeeController.loginEmployeeManager);
		
		
		/* Reimbursement End points */
		app.post("/reimbursements", ReimbursementController.createReimbursement);
		app.get("/reimbursements", ReimbursementController.getAllReimbursements);
		app.get("/reimbursements/:eid", ReimbursementController.getReimbursementsByEmployeeId);
		app.put("/reimbursements", ReimbursementController.updateReimbursement);
		
		
		
	}
}

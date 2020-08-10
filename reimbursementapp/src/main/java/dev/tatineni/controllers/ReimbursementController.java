package dev.tatineni.controllers;

import java.util.List;
import java.util.Set;

import com.google.gson.Gson;

import dev.tatineni.entities.Reimbursement;
import dev.tatineni.services.ReimbursementService;
import dev.tatineni.services.ReimbursementServiceImpl;
import io.javalin.http.Handler;

public class ReimbursementController {

	private static ReimbursementService reimServ = new ReimbursementServiceImpl();
	private static Gson gson = new Gson();
	
	public static Handler createReimbursement = (ctx)->{
		String ReimbursementJson = ctx.body();
		System.out.println(ctx.body());
		Reimbursement reimbursement = gson.fromJson(ReimbursementJson, Reimbursement.class); // transform the json into a Shcool object
		System.out.println(ReimbursementJson);
		System.out.println(reimbursement);
		
		reimServ.createReimbursement(reimbursement);
		ctx.status(201); // 201 is the status code to return if you successfully add something
		
		//usually you want to return the created object
		ctx.result(gson.toJson(reimbursement));
	};
	
	
	
	public static Handler getAllReimbursements = (ctx)->{
		
		List<Reimbursement> reimbursements = reimServ.getAllReimbursements();
		
		String json = gson.toJson(reimbursements);
		
		ctx.result(json);
		
	
	};
	
	public static Handler updateReimbursement = (ctx)-> {
		
		String reimbursementJson = ctx.body();
		System.out.println(reimbursementJson);
		Reimbursement reimbursement = gson.fromJson(reimbursementJson, Reimbursement.class);
		reimServ.updateReimbursement(reimbursement);
		
		ctx.result(gson.toJson(reimbursement));
		
		//Reimbursement reimbursement = reimServ.updateReimbursement();
		
	};
	
	
	public static Handler getReimbursementsByEmployeeId = (ctx)-> {
		
		String id = ctx.pathParam("eid");
		List<Reimbursement> reimbursements = reimServ.getReimbursementsByEmployeeId(Integer.parseInt(id));
		String json = gson.toJson(reimbursements);
		
		ctx.result(json);
		
	};
}

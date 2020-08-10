


$(document).ready(function() {
	
	$('#employeeView').hide();
	$('#managerView').hide();

	
	
	// LOGIN PAGE FUNCTIONS
	
	function loginEmployee(username,password){
		let queryURL = "http://localhost:7000/login/" + username +"/"+ password;
		
    	$.ajax({
      		url: queryURL,
      		method: "GET"
    	}).then(function(response) {
			if(response){
				console.log("Successful Login");
				$('#loginForm').hide();
				$('#employeeView').show();
				fillEmployeeReimbursementTable(response)
			}
			else{
				console.log("Incorrect Username or Password");
			}
    	});
		//console.log(employeeId.Id)
		//return employeeId.id

	}
	
	function loginManager(username,password){
		let queryURL = "http://localhost:7000/login/manager/" + username +"/"+ password;
    	$.ajax({
      		url: queryURL,
      		method: "GET"
    	}).then(function(response) {
			if(response){
				console.log("Successful Login");
				$('#loginForm').hide();
				$('#managerView').show();

			}
			else{
				console.log("Incorrect Username or Password");
			}
    	});
	}
	
	
	
	
	
	
	// MANAGER VIEW PAGE FUNCTIONS

	/* Fill rows in Manager Reimbursement Table */
	
	function fillManagerTable(){
		
		
		let currData = {"note":"",
							"status":"",
							rId:0 }
							
							
		let queryURL = "http://localhost:7000/reimbursements";
    	$.ajax({
      		url: queryURL,
      		method: "GET"
    	}).then(function(response) {
			
		
			const obj = JSON.parse(response)
			console.log(obj)
			// append table elements with info on click of the elements should show each in more detail
			for(i in obj){
				var approveCheckbox =  "<label><input type="+'checkbox'+" class='approvalSelect' data-id="+i+" /><span>approve</span></label>";
				var denyCheckbox = "<label><input type="+'checkbox'+" class='denySelect' data-id="+i+" /><span>deny</span></label>";
				var noteForm = "<div class='input-field col s6'><input placeholder='add note here' data-id="+i+" type='text' class='validate'><button id='submitApproval'>Submit</button></div>";
				var elem =  "<tr><td>"+ obj[i].eId + "</td><td>" + obj[i].amount + "</td><td>"+ obj[i].status + "</td><td>" + obj[i].reason + "</td><td>" + approveCheckbox +denyCheckbox+  "</td><td>"+ noteForm +"</td></tr>"
				$("#tableElementsManagerReimbursements").append(elem);
			}
					
			$(document).on("click",".approvalSelect",function(e){
				const id = $(this).data("id");
				// Index into json Array and update reimbursement table to change status to approved
				currData["status"] = "approved"
				currData["rId"] = obj[id].rId;

				
			})
			
			$(document).on("click",".denySelect",function(e){
				const id = $(this).data("id");
				// Index into json Array and update reimbursement table to change status to approved
				currData["status"] = "denied"
				currData["rId"] = obj[id].rId;
				
			})
			
		
			$(document).on("change",".validate",function(e){
				const text = e.currentTarget.value
				
				currData["note"]= text;
			});
			
			
			$(document).on("click","#submitApproval",function(e){
				
				// Call update request
				$.ajax({ 
					url: 'http://localhost:7000/reimbursements', 
					method: 'PUT', 
					data: JSON.stringify(currData)
				}).then(function() {
					$('#tableElementsManagerReimbursements').html("");
 					fillManagerTable();
				    
             		
           		});
				
			});
		
		
			
			
    	});

	}


// EMPLOYEE VIEW PAGE FUNCTIONS


function fillEmployeeReimbursementTable(employeeId){
	let currReiData = {"note":"",
					"status":"pending",
					 "reason":"",
					 "amount":0,
					 "eId": 0 
		}
	
	var queryURL = "http://localhost:7000/reimbursements/"+employeeId;
    $.ajax({
      	url: queryURL,
      	method: "GET"
    }).then(function(response) {
		
		const obj = JSON.parse(response)
		
		currReiData['eId'] = employeeId;
		
		if(obj != null)
		{
			for(i in obj){
				var elem =  "<tr><td>"+ obj[i].status + "</td><td>" + obj[i].reason + "</td><td>"+ obj[i].note+  "</td></tr>"
				$("#tableElementsEmployeeReimbursements").append(elem);
			//currReiData['eId']=obj[i].eId;
			}
		}
		
		
		$(document).on("click","#btnReimbursement",function(e) {
		
			const reason = document.getElementById("txtReason").value;
			const amount = document.getElementById("txtAmount").value;
		//	console.log(reason,amount,obj[i].eId)
			currReiData['reason'] = reason;
			currReiData['amount'] = amount;
				// send the post request for createReimbursement
				
			$.ajax({ 
				url: 'http://localhost:7000/reimbursements', 
				method: 'POST', 
				data: JSON.stringify(currReiData)
			}).then(function() {
				$('#tableElementsEmployeeReimbursements').html("");
 				fillEmployeeReimbursementTable(currReiData['eId']);
             		
           	});
		
		})	
	});			
}





// MAIN PAGE FUNCTIONS


	
$(document).on("click", "#btnLogin", function(e) {
    e.preventDefault();
    const username = document.getElementById("txtUsername").value;
    const pass = document.getElementById("txtPassword").value;

		
	if(document.getElementById('employeeLogin').checked){
		const loggedInUser = loginEmployee(username,pass);
		//	fillEmployeeReimbursementTable(loggedInUser);
	//	createReimbursementForm();

	}
	else if(document.getElementById('managerLogin').checked){
		loginManager(username,pass);
		fillManagerTable();

	}
  });

});










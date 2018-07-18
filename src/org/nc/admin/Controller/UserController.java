package org.nc.admin.Controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nc.admin.ServiceImplementation.UserServiceImplementation;
import org.nc.admin.beans.CourseBean;
import org.nc.admin.beans.RequestBean;
import org.nc.admin.beans.SuperCompanyBean;
import org.nc.admin.beans.TemplateBean;
import org.nc.admin.beans.TravelExpenseBean;
import org.nc.entitybeans.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan
public class UserController {

	@Autowired
	@Qualifier("userServiceImplementation")
	private UserServiceImplementation userServiceImplementation;
	
	@Autowired
	private ServletContext servletContext;

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public UserServiceImplementation getUserServiceImplementation() {
		return userServiceImplementation;
	}

	public void setUserServiceImplementation(UserServiceImplementation userServiceImplementation) {
		this.userServiceImplementation = userServiceImplementation;
	}
	
	@RequestMapping(value = "/Admin/success")
	public String successpage(ModelMap model) {
		return "/Admin/success";
	}
	@RequestMapping(value = "/Admin/error")
	public String errorpage(ModelMap model) {
		return "/Admin/error";
	}
	
	
			//CreateCompany
			@RequestMapping(value = "reemberse_request", method = RequestMethod.POST)
			public String CreateCompany(@ModelAttribute("bean") TravelExpenseBean bean, BindingResult result, ModelMap model) {
				
			
				
				if(this.userServiceImplementation.CreateReembersement(bean)==true)
				{
					
					return "Success";  
				
				}
				else 
				{
					return "error";
				}
					
				
			}
			
			
			
			
			
			@RequestMapping(value="/MANAGER/showExpenseViewData",method=RequestMethod.GET)
			public String showViewData(ModelMap model,@RequestParam(value = "master_id", required = true) int master_id) {
				model.addAttribute("expenseList", this.userServiceImplementation.getList(master_id));
				model.addAttribute("masterIdList", this.userServiceImplementation.getListofMasterData(master_id));
				return "/MANAGER/showExpenseViewData";
			}
			
	
		
			//Approve_Reermberse
			@RequestMapping(value = "/MANAGER/Approve_Reermberse", method = RequestMethod.POST)
			public String approve_reemberse(@ModelAttribute("bean") TravelExpenseBean bean, BindingResult result, ModelMap model) {
				if(this.userServiceImplementation.Approve_Reermberse(bean)==true)
				{
					return "redirect:/MANAGER/dashboard";  
				}
				else 
				{
					return "error";
				}
					
				
			}
			
			
			@RequestMapping(value = "/MANAGER/hello", method = RequestMethod.GET,produces="application/json")
			public String hello(@RequestParam(value = "requestId", required = true) String requestId,ModelMap model) {
				System.out.println("********************************");
				if(true)
				{
					return "redirect:/MANAGER/dashboard";  
				}
				else 
				{
					return "error";
				}
			}
			
			
			@RequestMapping(value="/demo1", method=RequestMethod.POST)
			public void Blockquestion(@RequestParam("requestId") String id,ModelMap model) {

			System.out.println("controller ge bartide:::::::::::");
			System.out.println("id::"+id);

		/*	InetAddress inetAddress = InetAddress.getLocalHost();
			       System.out.println("IP Address:- " + inetAddress.getHostAddress());
			       System.out.println("Host Name:- " + inetAddress.getHostName());
*/
		/*	if(this.hrServiceImplementation.BlockQuestion(id)) 
			{
			System.out.println("herererrerrerrerrrer");
			}
			else 
			{
			*/System.out.println("error while blocking the question");
			

			}  

			
			
			
			//Reject_Reermberse
			@RequestMapping(value = "/MANAGER/Reject_Reermberse", method = RequestMethod.POST)
			public String reject_reemberse(@ModelAttribute("bean") TravelExpenseBean bean, BindingResult result, ModelMap model) {
				if(this.userServiceImplementation.Reject_Reermberse(bean)==true)
				{
					return "redirect:/MANAGER/dashboard";  
				}
				else 
				{
					return "error";
				}
					
				
			}
		
			@RequestMapping(value = "/USER/requestform",method=RequestMethod.POST)
			public String requestform(@ModelAttribute("bean") UserRequest bean, BindingResult result, ModelMap model) {
				boolean isRequestDone = this.userServiceImplementation.requestform(bean);
				if(isRequestDone == true)
				{	
					return "Success";  
				
				}
				else 
				{
					return "error";
				}
					
				
			}
			
			
			
			
			@RequestMapping(value = "/USER/approvalrequest")
			public String approvalRequest() {
				

				
				/*if(this.userServiceImplementation.approvalRequest(id))
				{
					
					return "Success";  
				
				}
				else 
				{
					return "error";
				}*/
				System.out.println("Entered >>>>>>>>>>>>>>");
				return "demo";
					
				
			}
			
			/*//ApproveRequest @RequestParam("pName") String pName
			@RequestMapping(value = "/MANAGER/ApproveRequest", method = RequestMethod.POST)
			public @ResponseBody String ApproveRequest(HttpServletRequest request,@RequestBody String name) 
				{
					String[] str1 = new String[3];
					str1 = name.substring(0, name.length()-1).split("\\+");
					String requestId = str1[0];
					String budget = str1[1];
					String estimated_exp = str1[2];
					int newBudgetInHand = Integer.parseInt(budget) - Integer.parseInt(estimated_exp);
					
					boolean status = this.userServiceImplementation.approvalRequest(Integer.parseInt(requestId.trim()),newBudgetInHand);
					
					
					//int newBudgetInHand = Integer.p
			
					return "redirect:/MANAGER/dashboard";
				}*/
				
			/*	//RejectRequest
				@RequestMapping(value = "/MANAGER/RejectRequest", method = RequestMethod.GET)
				public String RejectRequest(@RequestParam(value = "request_id", required = true) int requestId,@RequestParam(value = "budget_in_hand", required = true) int budget_in_hand,ModelMap model) 
					{
						System.out.println("inside  controller");
						return "redirect:/MANAGER/dashboard";
					}
				*/
				
				/*@RequestMapping(value = "/MANAGER/pqr", method = RequestMethod.POST, produces = "application/json")
				public  @ResponseBody String home12345121()
				{      
					System.out.println("inside ajax controlller  p controller");
				     //System.out.println(data);
				String returnText;

				    
				String jsonString = "{\"firstName\":\"LOkesh\",\"lastNameKKdhgsdhsa\":\"Kargopolovsidsdkjsinsdksajid\"}";
				JsonParser jsonParser = new JsonParser();
				JsonObject objectFromString = jsonParser.parse(jsonString).getAsJsonObject();
				          

				          return null;
				     
				}*/
				
				
	/*			@RequestMapping(value = "/pqr", method = RequestMethod.POST, produces = "application/json")
				public  @ResponseBody String home12345121()
				{      System.out.println("inside ajax controlller  p controller");
				     //System.out.println(data);
				String returnText;

				    
				String jsonString = "{\"firstName\":\"LOkesh\",\"lastNameKKdhgsdhsa\":\"Kargopolovsidsdkjsinsdksajid\"}";
				JsonParser jsonParser = new JsonParser();
				JsonObject objectFromString = jsonParser.parse(jsonString).getAsJsonObject();
				          

				          return (objectFromString.toString());
				     
				}*/
				
				
				
				
			/*	//ViewQuestionsforJD
				@RequestMapping(value = "/Recruiter/ViewQuestionsforJD", method=RequestMethod.GET)
				public String ViewQuestionsforJD(@RequestParam(value="requirement_id", required = true) int requirement_id,ModelMap model) {
				model.addAttribute("QuestionsList",this.hrServiceImplementation.getQuestionsList(requirement_id));
				return "/Recruiter/ViewQuestions";
				}*/
				
				
				
				/*@RequestMapping(value = "/MANAGER/ApproveRequest", method = RequestMethod.POST)
				public @ResponseBody ModelAndView ApproveRequest(HttpServletRequest request,@RequestBody String name) 
				{
				ModelAndView modelAndView =new ModelAndView();
				String[] str1 = new String[3];
				str1 = name.substring(0, name.length()-1).split("\\+");
				String requestId = str1[0];
				int  budget = Integer.parseInt(str1[1]);
				int estimated_exp = Integer.parseInt(str1[2]);


				int newBudgetInHand =budget - estimated_exp;
				this.userServiceImplementation.approvalRequest(Integer.parseInt(requestId.trim()),newBudgetInHand);	

				modelAndView.setViewName("/MANAGER/dashboard");
				return modelAndView;
				}

				//RejectRequest
				@RequestMapping(value = "/MANAGER/RejectRequest", method = RequestMethod.POST)
				public @ResponseBody ModelAndView RejectRequest(HttpServletRequest request,@RequestBody String name) 
				{
				ModelAndView modelAndView =new ModelAndView();
				String requestId = name.substring(0, name.length()-1);
				this.userServiceImplementation.approvalRequest(Integer.parseInt(requestId.trim()),0);	
				System.out.println("inside  controller");
				modelAndView.setViewName("/MANAGER/dashboard");
				return modelAndView;
				}*/
				
				
				//ApproveRequest
				@RequestMapping(value = "/MANAGER/ApproveRequest/{requestId}/{budget}", method = RequestMethod.POST)
				@ResponseBody
				public String approveRequest(@PathVariable(value = "requestId") String requestId,@PathVariable(value = "budget") String budget) 
				{				
					this.userServiceImplementation.approvalRequest(Integer.parseInt(requestId),Integer.parseInt(budget));
					
						return budget;
					}
					
					//RejectRequest
					@RequestMapping(value = "/MANAGER/RejectRequest/{requestId}", method = RequestMethod.POST)
					@ResponseBody
					public void RejectRequest(@PathVariable(value = "requestId") String requestId) 	{
						this.userServiceImplementation.approvalRequest(Integer.parseInt(requestId),0);	
						}
/////////////////////////////////////////////////////////////////////	
	
	
}

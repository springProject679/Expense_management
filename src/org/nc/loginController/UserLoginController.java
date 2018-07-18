package org.nc.loginController;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.IteratedExpression;

import org.apache.log4j.Logger;
import org.nc.admin.ServiceImplementation.UserLoginServiceImplementation;
import org.nc.admin.beans.ManagerBudgetBean;
import org.nc.admin.beans.UsersBean;
import org.nc.entitybeans.ManagersBudget;
import org.nc.entitybeans.UserRequest;
import org.nc.entitybeans.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLoginController {
	
	@Autowired
	@Qualifier("messageProperty")
	private MessageProperty messageProperty;

	public MessageProperty getMessageProperty() {
		return messageProperty;
	}

	public void setMessageProperty(MessageProperty messageProperty) {
		this.messageProperty = messageProperty;
		
	}	
		
	@Autowired
	@Qualifier("userLoginServiceImplementation")
	private UserLoginServiceImplementation userLoginServiceImplementation;

	public UserLoginServiceImplementation getUserLoginServiceImplementation() {
		return userLoginServiceImplementation;
	}

	public void setUserLoginServiceImplementation(
			UserLoginServiceImplementation userLoginServiceImplementation) {
		this.userLoginServiceImplementation = userLoginServiceImplementation;
	}

	public static Logger getLogger() {
		return logger;
	}

	private static final Logger logger = Logger
			.getLogger(UserLoginController.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "index";
	}

/*	@RequestMapping(value = "/MANAGER/dashboard", method = RequestMethod.GET)
	public String Manager(ModelMap model, HttpServletRequest request) {
		
		String username = request.getSession().getAttribute("user").toString();
		model.addAttribute("user", username);
		Users user = this.userLoginServiceImplementation.getRoleNewData(username);
		request.getSession().setAttribute("roleNew", user.getRoleNew());
		ManagersBudget managerBudget=this.userLoginServiceImplementation.getManagerDetail(user.getManager_id());
		
		if (logger.isDebugEnabled()) {
			logger.debug(model);
		}
		List<UsersBean> listOfObject= this.userLoginServiceImplementation.getMasterList();
		
		model.addAttribute("masterList",listOfObject);
		model.addAttribute("managerData",managerBudget);
		//model.addAttribute("users",users);
		
			return "/MANAGER/dashboard";		
	}*/

	
	@RequestMapping(value = "/MANAGER/dashboard", method = RequestMethod.GET)
	public String Manager(ModelMap model, HttpServletRequest request) {
		
		String username = request.getSession().getAttribute("user").toString();
		model.addAttribute("user", username);
		Users user = this.userLoginServiceImplementation.getRoleNewData(username);
		request.getSession().setAttribute("roleNew", user.getRoleNew());
		ManagersBudget managerBudget=this.userLoginServiceImplementation.getManagerDetail(user.getManager_id());
		
		if (logger.isDebugEnabled()) {
			logger.debug(model);
		}
		List<UsersBean> listOfObject= this.userLoginServiceImplementation.getMasterList();
		
		model.addAttribute("masterList",listOfObject);
		model.addAttribute("managerData",managerBudget);
		
		//model.addAttribute("users",users);
		
			return "/MANAGER/dashboard";		
	}



	
	/*@RequestMapping(value = "/MANAGER/dashboard", method = RequestMethod.GET)
	public String Manager(ModelMap model, HttpServletRequest request) {
		
		String username = request.getSession().getAttribute("user").toString();
		model.addAttribute("user", username);
		Users user = this.userLoginServiceImplementation.getRoleNewData(username);
		request.getSession().setAttribute("roleNew", user.getRoleNew());
		
		if (logger.isDebugEnabled()) {
			logger.debug(model);
		}
		List<UsersBean> listOfObject= this.userLoginServiceImplementation.getMasterList();
		List<UserRequest> userRequests = (List<UserRequest>) listOfObject.get(0);
		List<Users> users =(List<Users>) listOfObject.get(1);
		Iterator<UserRequest> iterator =userRequests.iterator();
		
		while(iterator.hasNext()) {
			
		}
		
		
		
		model.addAttribute("masterList",listOfObject);
		//model.addAttribute("users",users);
		
			return "/MANAGER/dashboard";		
	}*/
	
	@RequestMapping(value = "/CFO/dashboard", method = RequestMethod.GET)
	public String CFO(ModelMap model, HttpServletRequest request) {
		model.addAttribute("user", request.getSession().getAttribute("user").toString());
		String username = request.getSession().getAttribute("user").toString();
		String roleNew = this.userLoginServiceImplementation.getRoleNewData(username).getRoleNew();
		request.getSession().setAttribute("roleNew", roleNew);
		
		if (logger.isDebugEnabled()) {
			logger.debug(model);
		}
		model.addAttribute("masterList",this.userLoginServiceImplementation.getMasterListForCFO());
			return "/CFO/dashboard";		
	}
	
	@RequestMapping(value = "/CXO/dashboard", method = RequestMethod.GET)
	public String CXO(ModelMap model, HttpServletRequest request) {
		model.addAttribute("user", request.getSession().getAttribute("user").toString());
		String username = request.getSession().getAttribute("user").toString();
		String roleNew = this.userLoginServiceImplementation.getRoleNewData(username).getRoleNew();
		request.getSession().setAttribute("roleNew", roleNew);
		
		if (logger.isDebugEnabled()) {
			logger.debug(model);
		}
		model.addAttribute("TL_Info",this.userLoginServiceImplementation.getTLInfo(username));
			return "/CXO/dashboard";		
	}
	
	@RequestMapping(value = "/TL/dashboard", method = RequestMethod.GET)
	public String TL(ModelMap model, HttpServletRequest request) {
		model.addAttribute("user", request.getSession().getAttribute("user").toString());
		String username = request.getSession().getAttribute("user").toString();
		String roleNew = this.userLoginServiceImplementation.getRoleNewData(username).getRoleNew();
		request.getSession().setAttribute("roleNew", roleNew);
		
		if (logger.isDebugEnabled()) {
			logger.debug(model);
		}
		
		model.addAttribute("Manager_Info",this.userLoginServiceImplementation.getManagerInfo(username));
			return "/TL/dashboard";		
	}
	
	@RequestMapping(value = "/USER/dashboard", method = RequestMethod.GET)
	public String USER(ModelMap model, HttpServletRequest request) {
		
		String username = request.getSession().getAttribute("user").toString();
		Users user = this.userLoginServiceImplementation.getRoleNewData(username);
		model.addAttribute("user", username);
		request.getSession().setAttribute("roleNew", user.getRoleNew());
		model.addAttribute("userInfo", user);
		return "/USER/requestUser";
	}
	
	
	//getExpensesByManagerWise
	@RequestMapping(value = "/TL/getExpensesByManagerWise", method = RequestMethod.GET)
	public String getExpensesByManagerWise(@RequestParam(value = "manager_id", required = true) int manager_id,ModelMap model) {
		model.addAttribute("userExpenses", this.userLoginServiceImplementation.getUserExpensesByManagerWise(manager_id));
		 return "/TL/ViewExpenses";
	}
	
	

}


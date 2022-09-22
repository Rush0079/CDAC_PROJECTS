package com.cdac.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.entity.User;
import com.cdac.exception.UserServiceException;
import com.cdac.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.cdac")
	public String login(HttpServletRequest request, HttpSession session, Map<String,Object> model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			User user = userService.login(username,password);
			session.setAttribute("username", username);
			model.put("userData", user);
			return "Payme.jsp";
		}catch(UserServiceException e ){
			model.put("message", e.getMessage());
			return "Login.jsp";
		}catch(NoResultException e ){
			model.put("message", e.getMessage());
			return "Login.jsp";
		}
	}
	@RequestMapping("/register.cdac")
	public String register(HttpServletRequest request, Map model) {
		 User user = new User();
		 user.setName(request.getParameter("name"));
		 user.setMobno(request.getParameter("mobno"));
		 user.setEmail(request.getParameter("email"));
		 user.setAadharno(request.getParameter("aadharno"));
		 user.setUsername(request.getParameter("username"));
		 user.setPassword(request.getParameter("password"));
			try {
			userService.register(user);
			return "Login.jsp";
			}catch(UserServiceException e) {
				model.put("message",e.getMessage());
				return "registration.jsp";
			}
	}
	
	@RequestMapping("/users.cdac")
	public String registeredUsers(HttpServletRequest request,Map<String,Object> model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
		List<User> list = (List<User>) userService.adminLogin(username,password);
		model.put("listOfUsers", list);
		return "list.jsp";
		}catch(UserServiceException e ){
			model.put("message", e.getMessage());
			return "admin.jsp";
		}catch(NoResultException e ){
			model.put("message", e.getMessage());
			return "admin.jsp";
		}
	}
	
	@RequestMapping("/removeUser.cdac")
	public String deleteUsers(HttpServletRequest request, Map<String, Object> model){
		String username = request.getParameter("username");
		
		if(userService.delete(username)) {
			model.put("message", "User successfully deleted.");
			return "list.jsp";
		}else
			model.put("message", "No user found.");
			return "list.jsp";
	}
	
	int amount;
	String mobno;
	
	@RequestMapping("/amountUpdate.cdac")
	public String balanceUpdate(HttpServletRequest request, Map<String, Object> model){
		 amount = (Integer.parseInt(request.getParameter("amount")));
		 mobno = request.getParameter("mobno");
		 return "cardPayment.jsp";
	}
	
	@RequestMapping("/amountUpdateFinal.cdac")
	public String balanceUpdate2(HttpServletRequest request, Map<String, Object> model){
		
		if(userService.recharge(mobno,amount))
			return "cardPayment.jsp";
	else 
		return "mobileRecharge.jsp";

	}
	
	@RequestMapping("/addMoney.cdac")
	public String walletUpdate(HttpServletRequest request, Map<String, Object> model){
		
		String mobno=request.getParameter("mobno");
		int amount=Integer.parseInt(request.getParameter("amount"));
		if(userService.wallet(mobno,amount)) {
			model.put("message", "Money added successfuly");
			return "addMoney.jsp";
			}
	else 
		model.put("message", "No user found.");
		return "addMoney.jsp";

	}
	
	@RequestMapping("/updateDetails.cdac")
	public String userUpdate(HttpServletRequest request, Map<String, Object> model){
		User nu = new User();
		String aadharno=request.getParameter("aadharNo");
		String name=request.getParameter("name");
		String mobno=request.getParameter("mobno");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		nu.setAadharno(aadharno);
		nu.setName(name);
		nu.setUsername(username);
		nu.setEmail(email);
		nu.setMobno(mobno);
		nu.setPassword(password);
		
		if(userService.change(nu)) {
			model.put("message", "Updated successfuly");
			return "updateProfile.jsp";
			}
	else 
		model.put("message", "No user found.");
		return "list.jsp";

	}
	
	@RequestMapping("/upi.cdac")
	public String upiPayment(HttpServletRequest request, Map<String, Object> model){
		
		String mobno1=request.getParameter("mobno1");
		String mobno2=request.getParameter("mobno2");
		int amount=Integer.parseInt(request.getParameter("amount"));
		
		if(userService.upi(mobno1, mobno2, amount)) {
			model.put("message", "Money sent successfuly");
			return "Upi.jsp";
			}
	else 
		model.put("message", "No transaction happened..");
		return "Upi.jsp";

	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "Login.jsp";
	}

}

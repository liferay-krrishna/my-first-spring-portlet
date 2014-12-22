package com.datatreis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.datatreis.model.User;
import com.datatreis.service.base.UserService;


@Controller
@RequestMapping ("VIEW")
public class HomeController {
	
	@Autowired  
	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RenderMapping
	public String defaultRender(RenderRequest request,RenderResponse response,Model model) {
		return "index";
	}

	/*@RequestMapping("/register") 
	public ModelAndView getRegisterForm(@ModelAttribute("user") User user,  
			BindingResult result) {  

		ArrayList<String> gender = new ArrayList<String>();  
		gender.add("Male");  
		gender.add("Female");  

		ArrayList<String> city = new ArrayList<String>();  
		city.add("Delhi");  
		city.add("Kolkata");  
		city.add("Chennai");  
		city.add("Bangalore");  

		Map<String, Object> model = new HashMap<String, Object>();  
		model.put("gender", gender);  
		model.put("city", city);  

		System.out.println("Register Form");  
		return new ModelAndView("Register", "model", model);  

	}  */

	//@RequestMapping("/saveUser")  
	@ActionMapping(params ="myaction=saveUser") 
	public void saveUserData(ActionRequest request, ActionResponse response, @ModelAttribute("user") User user,  
			BindingResult result) {  
		
		System.out.println("User Details===>"+user);
		userService.addUser(user);  
		System.out.println("Saving of User Data is Successful");  
		/*Map<String, Object> modelView = new HashMap<String, Object>();  
		modelView.put("users", userService.getUsers());*/
		//return new ModelAndView("userDetails",modelView);
		response.setRenderParameter("myaction", "userList");

	}  
	@RenderMapping(params = "myaction=userList")
	public String createUser(ModelMap modelMap, RenderRequest renderRequest,@ModelAttribute("user") User user) {
		/*System.out.println("hello");
		Map<String, Object> modelView = new HashMap<String, Object>();
		System.out.println("spandana"+userService.getUsers());
		
		modelView.put("user1", userService.getUsers());*/
		List<User> userList = new ArrayList<User>();
		userList = getUserService().getUsers();
		modelMap.addAttribute("user", userList);
		
		
		return "loginDetails";

	}


	/*//@RequestMapping("/userList") 
	@RenderMapping(params = "myaction=userList")
	public ModelAndView getUserList(RenderRequest request, RenderResponse response, Model model) {  
		//userService.addUser(user); 
		System.out.println("welcome to");
		Map<String, Object> modelView = new HashMap<String, Object>();  
		modelView.put("users", userService.getUsers());
		//System.out.println("user..........>+"+users.getId());
		return new ModelAndView("userDetails", modelView);  

	} */
	
	@RenderMapping(params ="myaction=register") 
	public ModelAndView register(RenderRequest request, RenderResponse response, Model model) {  

		Map<String, Object> modelView = new HashMap<String, Object>();  
		modelView.put("user", new User() );
		return new ModelAndView("Register", modelView);  

	}
	@RenderMapping(params = "action=editUserInfo")
	public String doUserUpdate(ModelMap modelMap,
			@RequestParam("userId") int id, RenderRequest renderRequest) {
		System.out.println("userEdit called" + id);
		
		renderRequest.setAttribute("userId", id);

		modelMap.addAttribute("user",
				getUserService().getUser(id));
		return "editUser"; 
	}
	@ActionMapping(params = { "action=userUpdateAction" })
	public void userUpdation(ActionRequest actionRequest,
			ActionResponse actionResponse,@ModelAttribute User user) {
		Integer id = Integer.parseInt(actionRequest.getParameter("id"));
		System.out.println(id);
		getUserService().updateUser(user);
	}
	@ActionMapping(params = "action=deleteUserInfo")
	public void userdelete(ModelMap modelMap, ActionRequest actionRequest,
			ActionResponse actionResponse) {
		Integer id = Integer.parseInt(actionRequest.getParameter("userId"));
		getUserService().deleteUser(id);
	}
}  



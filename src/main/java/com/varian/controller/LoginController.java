package com.varian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.varian.domain.User;
import com.varian.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public String login(Model model){
		/*ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;*/
		return "login";
	}
	
	
	/*@RequestMapping(value="/registration", method = RequestMethod.GET)
	public String registration(Model model){
//		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
//		modelAndView.addObject("user", user);
//		modelAndView.setViewName("registration");
		model.addAttribute("user", user);
		return "registration";
	}*/
	
	/*@RequestMapping(value="/registration/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "forgotPassword";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String createNewUser(Model model,@Valid User user, BindingResult bindingResult) {
//		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			return "registration";
		} else {
			userService.saveUser(user);
//			modelAndView.addObject("successMessage", "User has been registered successfully");
			model.addAttribute("successMessage", "User has been registered successfully");
//			modelAndView.setViewName("login");
//			return new ModelAndView("redirect:/login");
			return "redirect:login";
		}
	}*/
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public String home(Model model){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
//		modelAndView.addObject("userName", "Welcome " + user.getName());
//		modelAndView.addObject("user",user);
		model.addAttribute("userName", "Welcome " + user.getName());
		model.addAttribute("user",user);
		String viewName="";
		if(null!=user.getRoles() && user.getRoles().get(0).getRole().equals("ADMIN")) {
//			modelAndView.setViewName("adminHomePage");
			viewName = "adminHomePage";
		}else {
//			modelAndView.setViewName("userHomePage");
			viewName = "userHomePage";
		}
		return viewName;
	}
	

}

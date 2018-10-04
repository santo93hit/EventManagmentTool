package com.varian.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.varian.domain.User;
import com.varian.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String registration(Model model){
//		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
//		modelAndView.addObject("user", user);
//		modelAndView.setViewName("registration");
		model.addAttribute("user", user);
		return "registration";
	}
	
	@RequestMapping(value="/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword(Model model){
		/*User user = new User();
		model.addAttribute("user", user);*/
		return "forgotPassword";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
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
	}

}

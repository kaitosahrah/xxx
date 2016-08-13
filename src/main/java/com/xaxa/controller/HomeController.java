package com.xaxa.controller;

import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xaxa.model.User;
import com.xaxa.service.UserService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("init");
		model.addObject("user", new User());
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User userRequest, ModelAndView model) {
		System.out.println("Toi la ai");
		try {
			User user = userService.getById(userRequest.getUsername());
			if (user != null) {
				if (user.getPassword().equals(userRequest.getPassword())) {
					// login success
					model.setViewName("home");
					model.addObject("user", user);
				} else {
					// password wrong
					model.setViewName("init");
				}
			} else {
				// username wrong
				System.out.println("Username success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}
	
	
}

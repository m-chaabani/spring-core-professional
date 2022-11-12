package com.mc.gestionformation.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.mc.gestionformation.exception.UserNotFoundException;
import com.mc.gestionformation.model.Utilisateur;

@Controller("userCtr")
@SessionScope
//@RequestMapping("/users") // handler of URL http://localhost:8181/getionFormation/login
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);

	Utilisateur user;
	
//	@ExceptionHandler({NullPointerException.class, UserNotFoundException.class})
//	public ModelAndView handleUserNotFound(UserNotFoundException ex, HttpServletResponse response){
//		ModelAndView modelview = new ModelAndView("/error");
//		modelview.addObject("errorMessage", "Utilisateur non existant .....");
//		response.setStatus(401, " utilisateur non existant .....");
//		return modelview;
//		
//	}

	@ModelAttribute("user")
	Utilisateur initUser() {
		user = new Utilisateur();
		return user;
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	String showLoginPage() {
		return "/index";
	}

	@RequestMapping("/j_security_check") // http://localhost:8181/getionFormation/j_security_check
	public String checkUser(@ModelAttribute @Valid Utilisateur user, BindingResult result) {
		log.info("l'utilisateur connecter est : " + user.getUsername());
		if(user !=null && !user.getUsername().equals("test") ){
			throw  new UserNotFoundException();
		}
		if (result.hasErrors()) {
			log.error(result.getAllErrors().get(0).toString());
		}
		return "/private/acceuil";
	}

	@RequestMapping(value = "/edit", method = { RequestMethod.POST, RequestMethod.PUT }) // http://localhost:8181/getionFormation/users/create
	String createUser(HttpSession session) {
		return "";
	}

	@GetMapping(value = "/edit") // http://localhost:8181/getionFormation/login/create
	String createUserdd() {
		return "";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT) // http://localhost:8181/getionFormation/users/edit
	String updateUser() {
		return "";
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

}

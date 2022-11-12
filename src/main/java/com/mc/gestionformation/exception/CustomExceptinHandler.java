package com.mc.gestionformation.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptinHandler {

//extends ResponseEntityExceptionHandler // pour l'adapter aux API REST{
// ResponseEntity --> Abstraction Spring de l'object  Response Servlet  
	
//	@InitBinder
//	void m() {
//		
//	}
//	
//	@ModelAttribute
//	void modelAttribute() {
//		
//	}

	@ExceptionHandler({ NullPointerException.class, UserNotFoundException.class })
	@ResponseStatus
	public ModelAndView handleUserNotFound(UserNotFoundException ex, HttpServletResponse response) {
		ModelAndView modelview = new ModelAndView("/error");
		modelview.addObject("errorMessage", "Utilisateur non existant !!!!! ");
		response.setStatus(403, " utilisateur non existant !!!!!! ");
		return modelview;

	}

}

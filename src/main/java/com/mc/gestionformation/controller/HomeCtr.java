package com.mc.gestionformation.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@ResponseBody
@SessionScope
public class HomeCtr {

	@RequestMapping("/acceuil?id=2")
	// @ResponseBody
	public String index(HttpServletRequest request, Writer writer, @RequestHeader("HOST") String host2,
			@RequestHeader("USER-AGENT") String userAgent) throws IOException {
		String host = request.getHeader("Host");

		String s = "Bonjour tout le monde ! ";
		char[] c = s.toCharArray();
		for (char c1 : c)
			writer.append(c1);
		return host2 + " " + userAgent;
	}
	
	public String sayHello(HttpSession session){
		UserController userCtr = (UserController) session.getAttribute("userCtr");
		return "homePage";	
	}
}

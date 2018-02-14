package io.thrill.bookmark.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		System.out.println("serving");
		return "resources/index.html";   
	}
	
	@RequestMapping(value = "/static/{file}", method = RequestMethod.GET)
	public String serveStatic(@RequestParam String path,Locale locale, Model model) {	
		System.out.println("serving file"+path);
		return "resources/index.html";   
	}
	
}

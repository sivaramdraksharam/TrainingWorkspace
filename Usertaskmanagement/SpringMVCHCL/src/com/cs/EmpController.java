package com.cs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@RequestMapping("/Check")
	String sample(@RequestParam("userName") String name,Model m) {

		m.addAttribute("key", name);
		return "Disp";
	}

	@RequestMapping("/SignUp")
	ModelAndView register(@ModelAttribute Employee emp) {


		return new ModelAndView("Disp", "key", emp);
	}

}

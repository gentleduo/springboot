package org.gen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class IndexController {

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("name", "gentleduo");
		System.out.println("hello gentleduo!!!");
		return "index";
	}
}

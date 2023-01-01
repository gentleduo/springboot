package org.gen.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	/*
	 * @RequestMapping表示支持所有类型的请求，包括：get,post等
	 */
	@GetMapping("/hello")
	public String hello() {

		//int i = 1 / 0;
		return "hello spring boot";
	}
}

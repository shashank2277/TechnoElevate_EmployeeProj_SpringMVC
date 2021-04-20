package org.te.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDelegationController {

	@GetMapping("/redirect")
	public String redirectRequest() {
		return "redirect:http://google.com";
	}
	@GetMapping("/forward")
	public String forwardRequest() {
		return "forward:homePage";
	}
	
}

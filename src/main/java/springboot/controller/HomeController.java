package springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/welcome")
	public String home() {
		String text="this ia a private page";
		text+="this page is not allowed for unauthorized user";
		return text;
		
	}

}

package com.AttendanceSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
		@RequestMapping("/")
		public String showIndex(){
			
			System.out.println("ok");
			return "index";
		}
		
		@RequestMapping("/{model}-{page}")
		public String page(@PathVariable("model") String model,@PathVariable("page") String page){
			
			return model+'/'+page;
		}
}

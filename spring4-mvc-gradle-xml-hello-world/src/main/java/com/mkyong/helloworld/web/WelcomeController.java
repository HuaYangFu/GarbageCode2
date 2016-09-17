package com.mkyong.helloworld.web;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.helloworld.service.HelloWorldService;

@Controller
public class WelcomeController {

	private final HelloWorldService helloWorldService;

	@Autowired
	public WelcomeController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value = {"/"})
	public String returnToFormView() {
		return "index";
	}

	@RequestMapping(value = "FormController.do",params={"add"})
	public ModelAndView add(@RequestParam("name") String name, @RequestParam("value") String value) {

		helloWorldService.insert(name,value);

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("name", name);
		modelAndView.addObject("value", value);
		return modelAndView;
	}

	@RequestMapping(value = "FormController.do",params={"updata"})
	public ModelAndView updata(@RequestParam("name") String name,
							   @RequestParam("value") String value,
							   @RequestParam("newName") String newName,
							   @RequestParam("newValue") String newValue
							   )
	{
		helloWorldService.updata(name,value,newName,newValue);

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("name", name);
		modelAndView.addObject("value", value);
		return modelAndView;
	}

	@RequestMapping(value = "FormController.do",params={"query"})
	public ModelAndView query(@RequestParam("name") String name, @RequestParam("value") String value) {

		ArrayList list = helloWorldService.query();

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("name", name);
		modelAndView.addObject("result",list);
		modelAndView.addObject("value", value);
		return modelAndView;
	}

	@RequestMapping(value = "FormController.do",params={"remove"})
	public ModelAndView remove(@RequestParam("name") String name, @RequestParam("value") String value) {

		helloWorldService.remove(name,value);

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("name", name);
		modelAndView.addObject("value", value);
		return modelAndView;
	}
}
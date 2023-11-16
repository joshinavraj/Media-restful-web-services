package com.nav.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;

	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

//	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello-World");
	}

	@GetMapping(path = "hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {

		return new HelloWorldBean(String.format("Hello-World, %s", name));
	}

	@GetMapping(path = "hello-world-inter")
	public String helloWorldInternalized() {
		Locale local=LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null,"Default message",local);
	}

}

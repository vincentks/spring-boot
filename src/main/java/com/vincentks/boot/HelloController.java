package com.vincentks.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot, bacon!";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody 
	@Transactional
	public String save(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return "OK";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	@Transactional(readOnly = true)
	public List<Customer> list() {
		return (List<Customer>) customerRepository.findAll();
	}
	
}

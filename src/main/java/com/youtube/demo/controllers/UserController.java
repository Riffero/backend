package com.youtube.demo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.demo.model.User;
import com.youtube.demo.service.UserService;
import com.youtube.demo.util.RestResponse;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse seveOrUpdate(@RequestBody String userJason)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJason, User.class);
		
		if(!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no deben ser vacios");
		}
		this.userService.save(user);
		
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}

	private boolean validate(User user) {
		boolean isValid = true;

		if (user.getFirstName() == null || user.getFirstName() == "") {
			isValid = false;
		}
		if (user.getFirstSurname() == null || user.getFirstSurname() == "") {
			isValid = false;
		}
		if (user.getAddress() == null || user.getAddress() == "") {
			isValid = false;
		}
		
		return isValid;
	}

}

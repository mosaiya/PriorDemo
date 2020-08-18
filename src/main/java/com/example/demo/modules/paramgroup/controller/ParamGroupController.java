package com.example.demo.modules.paramgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modules.paramgroup.services.ParamGroupService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/paramgroup")
public class ParamGroupController {
		
	@Autowired
	private ParamGroupService groupService ;
	
	
}

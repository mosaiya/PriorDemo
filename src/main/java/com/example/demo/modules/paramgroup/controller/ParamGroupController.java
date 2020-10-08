package com.example.demo.modules.paramgroup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ParamGroup;
import com.example.demo.modules.paramgroup.services.ParamGroupService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/paramgroup")
public class ParamGroupController {
		
	@Autowired
	private ParamGroupService groupService ;
	
	@GetMapping("/inquiry")
	public List<ParamGroup> inquiry(){
		List<ParamGroup> paramGroups = new ArrayList<>();
		return paramGroups ;
	}


	@PostMapping("/insert")
	public void testApiPost (@RequestBody ReqTestModel reqTestModel ){
		groupService.insert(reqTestModel);
	}
	@GetMapping("/nodelete")
	public List<ParamGroup> testApiPost (){
		return groupService.NoDelete();
	}

	@GetMapping("/deleteparmgroup/{paramgroupid}")
	public void DeleteParamGroup (@PathVariable Long paramgroupid ){
		groupService.Delete(paramgroupid);
	}
	
	@PostMapping("/edit")
	public void EditParamGroup (@RequestBody EditReq editReq ){
		groupService.Edit(editReq);
	}


}

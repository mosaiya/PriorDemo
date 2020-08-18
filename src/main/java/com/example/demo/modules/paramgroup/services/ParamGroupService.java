package com.example.demo.modules.paramgroup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ParameterGroupRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParamGroupService {
		
		@Autowired
		private ParameterGroupRepository groupRepository ;
}

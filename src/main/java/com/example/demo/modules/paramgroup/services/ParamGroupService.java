package com.example.demo.modules.paramgroup.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ParamGroup;
import com.example.demo.repository.ParameterGroupRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParamGroupService {
		
		@Autowired
		private ParameterGroupRepository groupRepository ;
		
		public List<ParamGroup> InquiryParamGroup(Long paramGroup) {
			List<ParamGroup> cpipMsParameterGroups = new ArrayList<>();
			try {
				 cpipMsParameterGroups = groupRepository.findByParamGroupIdAndIsDeleted(paramGroup, "N");
				
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
			
			return cpipMsParameterGroups ;
		}
}

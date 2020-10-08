package com.example.demo.modules.paramgroup.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.modules.paramgroup.controller.EditReq;
import com.example.demo.modules.paramgroup.controller.ReqTestModel;
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
		

		public  void insert(ReqTestModel reqTestModel){
			ParamGroup paramGroup  = new ParamGroup();
			System.out.println("reqTestModel.getParamGroup()"+reqTestModel.getParamGroup());
			paramGroup.setParamGroup(reqTestModel.getParamGroup());
			paramGroup.setParamEnDescription(reqTestModel.getParamEnDescription());
			paramGroup.setParamLocalDescription(reqTestModel.getParamLocalDescription());
			System.out.println("paramGroup.setParamLocalDescription"+paramGroup.getParamLocalDescription());
			groupRepository.save(paramGroup);
		}
		public  List<ParamGroup> NoDelete(){
			List<ParamGroup> paramGroupList = new ArrayList<>();
			try {
				 paramGroupList = groupRepository.findByIsDeleted("Y");
			}catch (Exception e){
				return paramGroupList ;
			}
			return  paramGroupList  ;
		}
	public void Delete(Long paramGroupId){
		ParamGroup paramGroup = new ParamGroup();
		try {
			paramGroup = groupRepository.findByParamGroupIdAndIsDeleted(paramGroupId , "N");
			paramGroup.setIsDeleted("Y");
			groupRepository.save(paramGroup);
		}catch (Exception e) {

		}
	}
	public  void  Edit(EditReq editReq){
		ParamGroup paramGroup = new ParamGroup();
		try {
			paramGroup = groupRepository.findByParamGroupIdAndIsDeleted(editReq.getParamGroupId() , "N");
			paramGroup.setParamGroup(editReq.getParamGroup());
			paramGroup.setParamEnDescription(editReq.getParamEnDescription());
			groupRepository.save(paramGroup);
		}catch (Exception e) {

		}
	}
	

}

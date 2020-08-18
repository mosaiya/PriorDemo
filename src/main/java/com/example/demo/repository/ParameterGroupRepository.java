package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ParamGroup;

@Repository
public interface ParameterGroupRepository extends JpaRepository<ParamGroup, Long> {
	
	List<ParamGroup>  findByParamGroupIdAndIsDeleted(Long paramGroupId , String isDeleted);
	
	List<ParamGroup> findAll();

	List<ParamGroup> findByParamGroupAndParamEnDescription(String T1 , String T2);
}

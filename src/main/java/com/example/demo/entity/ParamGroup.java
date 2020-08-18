package com.example.demo.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CPIP_MS_PARAMETER_GROUP")
public class ParamGroup {
		
	@Id
    @SequenceGenerator(name = "param_group_id_seq",sequenceName = "CPIP_MS_PARAMETER_GROUP_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "param_group_id_seq")
    private Long paramGroupId;
	
    private String paramGroup;
    
    private String paramEnDescription;

    private String paramLocalDescription;
}

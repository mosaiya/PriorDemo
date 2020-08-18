package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import java.io.IOException;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity<T> {

	@Column(updatable = false, insertable = true)
	@JsonIgnore
	@CreationTimestamp
	protected Timestamp createdDate;

	@Column(updatable = false, insertable = true)
	@JsonIgnore
	@CreatedBy
	protected String createdBy = "admin";

	@Column(updatable = true, insertable = false)
	@JsonIgnore
	@UpdateTimestamp
	protected Timestamp updatedDate;

	@Column(updatable = true, insertable = false)
	@JsonIgnore
	@LastModifiedBy
	protected String updatedBy = "admin";

	@JsonIgnore
	protected String isDeleted = "N" ;

	@JsonIgnore
	@Transient
	protected T previousState;

	@SuppressWarnings("unchecked")
	@PostLoad
	private void setPreviousState() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String serialized = mapper.writeValueAsString(this);
		this.previousState = (T) mapper.readValue(serialized, this.getClass());
	}

	public T getPreviousState() {
		return previousState;
	}

	@PrePersist
	public void prePersist() {
		String userId = "ADMIN";
		setCreatedDate(new Timestamp(System.currentTimeMillis()));
		setCreatedBy(userId);
		setIsDeleted("N");
	}

	@PreUpdate
	public void preUpdate() {
		String userId = "ADMIN";
		setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		setUpdatedBy(userId);
	}
}

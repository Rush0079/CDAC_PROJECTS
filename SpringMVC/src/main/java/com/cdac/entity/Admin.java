package com.cdac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_admin")
public class Admin {
	@Id
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;

}

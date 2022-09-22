package com.cdac.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_funds")
public class Funds {

	@Id
	@Column(nullable=false)
		private String mobno;
	@Column(nullable=false)
		private String ban;
	@Column(nullable=false)
		private Double balance;
	
}

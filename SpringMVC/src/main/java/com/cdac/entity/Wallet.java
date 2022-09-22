package com.cdac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_wallet")
public class Wallet {

	@Id
	@Column(nullable=false)
	private String mobno;
	@Column(nullable=false)
	private int balance;
	
}

package com.rentatrip.Model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GEN")
	@SequenceGenerator(name = "USER_ID_GEN", sequenceName = "USER_ID_SEQ", initialValue = 1_000, allocationSize = 1)
	@Column(name = "user_id")
	private long id;
	
	private String name;

	private String email;
	
	private String username = this.email;

	@JsonIgnoreProperties({ "password" })
	private String password;

	@Lob
	private byte[] picByte;

	private String address;
	private String accountType ="user";
	private String phoneNumber;
	private String resetToken;
    private String tokenCreateTime;



	public User() {
		
	}



	public User(long id, String name, String email, String username, String password, byte[] picByte, String address,
			String accountType, String phoneNumber, String resetToken, String tokenCreateTime) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.picByte = picByte;
		this.address = address;
		this.accountType = accountType;
		this.phoneNumber = phoneNumber;
		this.resetToken = resetToken;
		this.tokenCreateTime = tokenCreateTime;
		
	}
	
	

	public User(long id, String name, String email, String username, byte[] picByte, String address, String accountType,
			String phoneNumber, String resetToken, String tokenCreateTime) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.picByte = picByte;
		this.address = address;
		this.accountType = accountType;
		this.phoneNumber = phoneNumber;
		this.resetToken = resetToken;
		this.tokenCreateTime = tokenCreateTime;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public byte[] getPicByte() {
		return picByte;
	}


	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getResetToken() {
		return resetToken;
	}


	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}


	public String getTokenCreateTime() {
		return tokenCreateTime;
	}


	public void setTokenCreateTime(String tokenCreateTime) {
		this.tokenCreateTime = tokenCreateTime;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + ", picByte=" + Arrays.toString(picByte) + ", address=" + address + ", accountType="
				+ accountType + ", phoneNumber=" + phoneNumber + ", resetToken=" + resetToken + ", tokenCreateTime="
				+ tokenCreateTime + "]";
	}





	
	

}

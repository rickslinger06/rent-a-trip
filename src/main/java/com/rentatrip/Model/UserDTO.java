package com.rentatrip.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserDTO {
	
	

	private long id;

	private String name;
	private String email;
	private String username = this.email;
	private String password;
	private byte[] picByte;
	private String address;
	private String accountType ="user";
	private String phoneNumber;
	private String resetToken;
    private String tokenCreateTime;

public UserDTO() {
	
}

public UserDTO(long id, String name, String email, String username, byte[] picByte, String address,
		String accountType, String phoneNumber, String resetToken, String tokenCreateTime) {
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

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
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

public String getAccountType() {
	return accountType;
}

public void setAccountType(String accountType) {
	this.accountType = accountType;
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








}

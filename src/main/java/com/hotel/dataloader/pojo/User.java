package com.hotel.dataloader.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int registrationId;
	private String  userName;
	private  String password;
	private  String emailId;
	private  String role;
	public User(String userName, String password, String emailId, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.role = role;
	}

}

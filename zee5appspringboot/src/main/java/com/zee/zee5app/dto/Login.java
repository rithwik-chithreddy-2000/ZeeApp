package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "login")
public class Login implements Comparable<Login> {
	
	@Id
	@Email
	private String username;
	@NotBlank
	private String password;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "userId")
	private User user;
	
	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.username.compareTo(this.getUsername());
	}

}

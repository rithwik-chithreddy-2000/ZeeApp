package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@Table(name = "register")
public class Register implements Comparable<Register> {
	
//	public Register(String id, String firstName, String lastName, String email, String password, BigDecimal contactNumber)
//			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//		super();
//		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.setEmail(email);
//		this.setPassword(password);
//		this.contactNumber = contactNumber;
//	}

	@Id
	@Column(name = "regId")
	private String id;
	
	@Size(max = 50)
	@NotBlank
	private String firstName;
	
	@Size(max = 50)
	@NotBlank
	private String lastName;
	
	@Size(max = 50)
	@Email
	private String email;
	
	@Size(max = 100)
	@NotBlank
	private String password;
	
	@Size(min = 10, max = 10)
	@NotBlank
	private String contactNumber;

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}

}

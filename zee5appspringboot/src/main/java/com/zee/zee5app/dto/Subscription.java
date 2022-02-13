package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscription")
public class Subscription implements Comparable<Subscription> {
	
	@Id
	@Column(name = "subId")
	private String id;
	@NotBlank
	private String dateOfPurchase;
	@NotBlank
	private String expiryDate;
	@NotNull
	private float amount;
	@NotBlank
	private String paymentMode;
	@NotBlank
	private String status;
	@NotBlank
	private String type;
	@NotBlank
	private String autoRenewal;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "userId")
	private User user;
	
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}

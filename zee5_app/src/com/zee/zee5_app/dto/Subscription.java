package com.zee.zee5_app.dto;

import lombok.Data;

@Data
public class Subscription {
	
	private String id;
	private String type;
	private String dateOfPurchase;
	private String status;
	private String packCountry;
	private String paymentMode;
	private boolean autoRenewal;
	private String expiryDate;

}

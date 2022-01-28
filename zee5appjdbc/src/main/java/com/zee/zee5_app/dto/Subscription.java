package com.zee.zee5_app.dto;

import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.LocationNotFoundException;

import lombok.AccessLevel;
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
public class Subscription implements Comparable<Subscription> {
	
	public Subscription(String id, String type, String dateOfPurchase, String status, String packCountry,
			String paymentMode, boolean autoRenewal, String expiryDate)
					throws InvalidIdLengthException, LocationNotFoundException {
		super();
		this.setId(id);
		this.type = type;
		this.dateOfPurchase = dateOfPurchase;
		this.status = status;
		this.packCountry = packCountry;
		this.paymentMode = paymentMode;
		this.autoRenewal = autoRenewal;
		this.expiryDate = expiryDate;
	}
	@Setter(value = AccessLevel.NONE)
	private String id;
	private String type;
	private String dateOfPurchase;
	private String status;
	private String packCountry;
	private String paymentMode;
	private boolean autoRenewal;
	private String expiryDate;
	
	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6)
			throw new InvalidIdLengthException("id length is less than 6");
		this.id = id;
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, type, dateOfPurchase, status, packCountry, paymentMode, autoRenewal, expiryDate);
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj)
//			return true;
//		if(obj == null)
//			return false;
//		if(getClass() != obj.getClass())
//			return false;
//		Subscription other = (Subscription) obj;
//		return Objects.equals(id, other.id) && Objects.equals(type, other.type)
//				&& Objects.equals(dateOfPurchase, other.dateOfPurchase) && Objects.equals(status, other.status)
//				&& Objects.equals(packCountry, other.packCountry) && Objects.equals(paymentMode, other.paymentMode)
//				&& Objects.equals(autoRenewal, other.autoRenewal) && Objects.equals(expiryDate, other.expiryDate);
//	}
	
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}

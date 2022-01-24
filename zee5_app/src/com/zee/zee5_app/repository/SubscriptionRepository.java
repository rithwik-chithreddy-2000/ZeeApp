package com.zee.zee5_app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.dto.Subscription;
import com.zee.zee5_app.exception.IdNotFoundException;

public interface SubscriptionRepository {
	
	public String addSubscription(Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException;
	public Subscription[] getAllSubscriptions();
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException;
	public String deleteSubscription(String id) throws IdNotFoundException;
	public List<Subscription> getAllSubscriptionDetails();

}

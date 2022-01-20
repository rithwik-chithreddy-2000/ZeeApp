package com.zee.zee5_app.repository;

import com.zee.zee5_app.dto.Subscription;

public interface SubscriptionRepository {
	
	public String addSubscription(Subscription subscription);
	public Subscription getSubscriptionById(String id);
	public Subscription[] getAllSubscriptions();
	public String modifySubscription(String id, Subscription subscription);
	public String deleteSubscription(String id);

}

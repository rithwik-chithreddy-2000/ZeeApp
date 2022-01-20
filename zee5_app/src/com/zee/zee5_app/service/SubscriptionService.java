package com.zee.zee5_app.service;

import com.zee.zee5_app.dto.Subscription;

public interface SubscriptionService {
	
	public String addSubscription(Subscription subscription);
	public Subscription getSubscriptionById(String id);
	public Subscription[] getAllSubscriptions();
	public String modifySubscription(String id, Subscription subscription);
	public String deleteSubscription(String id);

}

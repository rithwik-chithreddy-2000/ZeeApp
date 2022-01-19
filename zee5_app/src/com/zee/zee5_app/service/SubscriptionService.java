package com.zee.zee5_app.service;

import com.zee.zee5_app.dto.Subscription;
import com.zee.zee5_app.repository.SubscriptionRepository;

public class SubscriptionService {
	
	private SubscriptionRepository subscriptionRepository = SubscriptionRepository.getInstance();
	private SubscriptionService() {
		// TODO Auto-generated constructor stub
	}
	
	public String addSubsciption(Subscription subscription) {
		return this.subscriptionRepository.addSubscription(subscription);
	}
	
	public Subscription getSubscriptionById(String id) {
		return this.subscriptionRepository.getSubscriptionById(id);
	}
	
	public Subscription[] getAllSubscriptions() {
		return this.subscriptionRepository.getAllSubscriptions();
	}
	
	public String modifySubsciption(String id, Subscription subscription) {
		return this.subscriptionRepository.modifySubscription(id, subscription);
	}
	
	public String deleteSubscription(String id) {
		return this.subscriptionRepository.deleteSubscription(id);
	}
	
	private static SubscriptionService subscriptionService;
	public static SubscriptionService getInstance() {
		if(subscriptionService==null)
			subscriptionService = new SubscriptionService();
		return subscriptionService;
	}

}

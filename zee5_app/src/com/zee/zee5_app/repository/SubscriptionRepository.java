package com.zee.zee5_app.repository;

import com.zee.zee5_app.dto.Subscription;

public class SubscriptionRepository {
	
	private Subscription[] subscriptions = new Subscription[10];
	private static int subscriptionCount = -1;
	private SubscriptionRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public String addSubscription(Subscription subscription) {
		if(subscriptionCount==subscriptions.length-1) {
			Subscription temp[] = new Subscription[subscriptions.length*2];
			System.arraycopy(subscriptions, 0, temp, 0, subscriptions.length);
			subscriptions = temp;
		}
		subscriptions[++subscriptionCount] = subscription;
		return "Success";
	}
	
	public Subscription getSubscriptionById(String id) {
		for (Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getId().equals(id))
				return subscription;
		}
		return null;
	}
	
	public Subscription[] getAllSubscriptions() {
		return subscriptions;
	}
	
	public String modifySubscription(String id, Subscription subscription) {
		for (int i = 0; i < subscriptions.length; i++) {
			if(subscriptions[i].getId().equals(id)) {
				subscriptions[i] = subscription;
				return "Modified";
			}
		}
		return "Id does not exist";
	}
	
	public String deleteSubscription(String id) {
		for (int i = 0; i < subscriptions.length; i++) {
			if(subscriptions[i].getId().equals(id)) {
				System.arraycopy(subscriptions, i+1, subscriptions, i, subscriptionCount-i);
				subscriptions[subscriptionCount--] = null;
				return "Deleted";
			}
		}
		return "Id does not exist";
	}
	
	private static SubscriptionRepository subscriptionRepository;
	public static SubscriptionRepository getInstance() {
		if(subscriptionRepository==null)
			subscriptionRepository = new SubscriptionRepository();
		return subscriptionRepository;
	}

}

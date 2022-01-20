package com.zee.zee5_app.repository.impl;

import com.zee.zee5_app.dto.Subscription;
import com.zee.zee5_app.repository.SubscriptionRepository;

public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	
	private Subscription[] subscriptions = new Subscription[10];
	private static int subscriptionCount = -1;
	
	private SubscriptionRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static SubscriptionRepository subscriptionRepository;
	public static SubscriptionRepository getInstance() {
		if(subscriptionRepository==null)
			subscriptionRepository = new SubscriptionRepositoryImpl();
		return subscriptionRepository;
	}

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		if(subscriptionCount==subscriptions.length-1) {
			Subscription temp[] = new Subscription[subscriptions.length*2];
			System.arraycopy(subscriptions, 0, temp, 0, subscriptions.length);
			subscriptions = temp;
		}
		subscriptions[++subscriptionCount] = subscription;
		return "Success";
	}

	@Override
	public Subscription getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		for (Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getId().equals(id))
				return subscription;
		}
		return null;
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		return subscriptions;
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		for (int i = 0; i < subscriptions.length; i++) {
			if(subscriptions[i].getId().equals(id)) {
				subscriptions[i] = subscription;
				return "Modified";
			}
		}
		return "Id does not exist";
	}

	@Override
	public String deleteSubscription(String id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < subscriptions.length; i++) {
			if(subscriptions[i].getId().equals(id)) {
				System.arraycopy(subscriptions, i+1, subscriptions, i, subscriptionCount-i);
				subscriptions[subscriptionCount--] = null;
				return "Deleted";
			}
		}
		return "Id does not exist";
	}

}

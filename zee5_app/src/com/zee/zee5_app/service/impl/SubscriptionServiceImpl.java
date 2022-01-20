package com.zee.zee5_app.service.impl;

import com.zee.zee5_app.dto.Subscription;
import com.zee.zee5_app.repository.SubscriptionRepository;
import com.zee.zee5_app.repository.impl.SubscriptionRepositoryImpl;
import com.zee.zee5_app.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
	
	private SubscriptionRepository subscriptionRepository = SubscriptionRepositoryImpl.getInstance();
	private SubscriptionServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static SubscriptionService subscriptionService;
	public static SubscriptionService getInstance() {
		if(subscriptionService==null)
			subscriptionService = new SubscriptionServiceImpl();
		return subscriptionService;
	}

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepository.addSubscription(subscription);
	}

	@Override
	public Subscription getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return subscriptionRepository.getSubscriptionById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		return subscriptionRepository.getAllSubscriptions();
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepository.modifySubscription(id, subscription);
	}

	@Override
	public String deleteSubscription(String id) {
		// TODO Auto-generated method stub
		return subscriptionRepository.deleteSubscription(id);
	}

}

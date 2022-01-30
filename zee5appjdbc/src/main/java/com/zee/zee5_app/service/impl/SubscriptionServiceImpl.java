package com.zee.zee5_app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.dto.Subscription;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.repository.SubscriptionRepository;
import com.zee.zee5_app.repository.impl.SubscriptionRepositoryImpl;
import com.zee.zee5_app.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
	
	private SubscriptionRepository subscriptionRepository = SubscriptionRepositoryImpl.getInstance();
	private SubscriptionServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	private static SubscriptionService subscriptionService;
	public static SubscriptionService getInstance() throws IOException {
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
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return subscriptionRepository.getSubscriptionById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return subscriptionRepository.getAllSubscriptions();
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return subscriptionRepository.modifySubscription(id, subscription);
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return subscriptionRepository.deleteSubscription(id);
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptionDetails() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return subscriptionRepository.getAllSubscriptionDetails();
	}

}

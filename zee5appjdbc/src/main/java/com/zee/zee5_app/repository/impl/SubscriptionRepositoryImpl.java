package com.zee.zee5_app.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.dto.Subscription;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.repository.SubscriptionRepository;

public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	
	private ArrayList<Subscription> arrayList = new ArrayList<Subscription>();
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
		boolean result = this.arrayList.add(subscription);
		if(result)
			return "Success";
		return "Fail";
	}
	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Subscription subscription2 = null;
		for (Subscription subscription : arrayList) {
			if(subscription.getId().equals(id)) {
				subscription2 = subscription;
				break;
			}
		}
		return Optional.of(Optional.ofNullable(subscription2).orElseThrow(() -> new IdNotFoundException("id not found")));
	}
	@Override
	public Subscription[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		Subscription subscription[] = new Subscription[arrayList.size()];
		return arrayList.toArray(subscription);
	}
	@Override
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException {
		// TODO Auto-generated method stub
		String result = this.deleteSubscription(id);
		if(result=="Failed")
			return "Failed";
		result = this.addSubscription(subscription);
		if(result=="Fail")
			return "Failed";
		return "Updated";
	}
	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Subscription> optional = this.getSubscriptionById(id);
		boolean result = arrayList.remove(optional.get());
		if(result)
			return "Deleted";
		return "Failed";
	}
	@Override
	public List<Subscription> getAllSubscriptionDetails() {
		// TODO Auto-generated method stub
		Collections.sort(arrayList);
		return arrayList;
	}

}

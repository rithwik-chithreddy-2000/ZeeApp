package com.zee.zee5_app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.dto.Subscription;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.repository.SubscriptionRepository;
import com.zee.zee5_app.utils.DBUtils;

public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	
	private DBUtils dbUtils = DBUtils.getInstance();
	private SubscriptionRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	private static SubscriptionRepository subscriptionRepository;
	public static SubscriptionRepository getInstance() throws IOException {
		if(subscriptionRepository==null)
			subscriptionRepository = new SubscriptionRepositoryImpl();
		return subscriptionRepository;
	}
	
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		
		String insertStatement = "INSERT INTO subscription"
				+ " (subId, dateOfPurchase, expiry, amount, paymentMode, status, type, autoRenewal, regId)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, subscription.getId());
			preparedStatement.setString(2, subscription.getDateOfPurchase());
			preparedStatement.setString(3, subscription.getExpiryDate());
			preparedStatement.setFloat(4, subscription.getAmount());
			preparedStatement.setString(5, subscription.getPaymentMode());
			preparedStatement.setString(6, subscription.getStatus());
			preparedStatement.setString(7, subscription.getType());
			preparedStatement.setString(8, subscription.getAutoRenewal());
			preparedStatement.setString(9, subscription.getRegId());
			
			int result = preparedStatement.executeUpdate();
			
			if (result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}
	
	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		String selectStatement = "SELECT * FROM subscription WHERE subId=?";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Subscription subscription = new Subscription();
				subscription.setId(resultSet.getString("subId"));
				subscription.setDateOfPurchase(resultSet.getString("dateOfPurchase"));
				subscription.setExpiryDate(resultSet.getString("expiry"));
				subscription.setAmount(resultSet.getFloat("amount"));
				subscription.setPaymentMode(resultSet.getString("paymentMode"));
				subscription.setStatus(resultSet.getString("status"));
				subscription.setType(resultSet.getString("type"));
				subscription.setAutoRenewal(resultSet.getString("autoRenewal"));
				subscription.setRegId(resultSet.getString("regId"));
				return Optional.of(subscription);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}
	
	@Override
	public Subscription[] getAllSubscriptions() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		Optional<List<Subscription>> optional = getAllSubscriptionDetails();
		if(optional.isEmpty())
			return null;
		else {
			List<Subscription> list = optional.get();
			Subscription[] subscriptions = new Subscription[list.size()];
			return list.toArray(subscriptions);
		}
	}
	
	@Override
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		
		String updateStatement = "UPDATE subscription"
				+ " SET subId = ?, dateOfPurchase = ?, expiry = ?, amount = ?, paymentMode = ?,"
				+ " status = ?, type = ?, autoRenewal = ?, regId = ?"
				+ " WHERE (subId = ?)";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, subscription.getId());
			preparedStatement.setString(2, subscription.getDateOfPurchase());
			preparedStatement.setString(3, subscription.getExpiryDate());
			preparedStatement.setFloat(4, subscription.getAmount());
			preparedStatement.setString(5, subscription.getPaymentMode());
			preparedStatement.setString(6, subscription.getStatus());
			preparedStatement.setString(7, subscription.getType());
			preparedStatement.setString(8, subscription.getAutoRenewal());
			preparedStatement.setString(9, subscription.getRegId());
			preparedStatement.setString(10, id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}
	
	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		
		String deleteStatement = "DELETE FROM subscription WHERE subId=?";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}
	
	@Override
	public Optional<List<Subscription>> getAllSubscriptionDetails() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Subscription> arrayList = new ArrayList<Subscription>();
		
		String selectStatement = "SELECT * FROM subscription";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Subscription subscription = new Subscription();
				subscription.setId(resultSet.getString("subId"));
				subscription.setDateOfPurchase(resultSet.getString("dateOfPurchase"));
				subscription.setExpiryDate(resultSet.getString("expiry"));
				subscription.setAmount(resultSet.getFloat("amount"));
				subscription.setPaymentMode(resultSet.getString("paymentMode"));
				subscription.setStatus(resultSet.getString("status"));
				subscription.setType(resultSet.getString("type"));
				subscription.setAutoRenewal(resultSet.getString("autoRenewal"));
				subscription.setRegId(resultSet.getString("regId"));
				arrayList.add(subscription);
			}
			return Optional.ofNullable(arrayList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

}
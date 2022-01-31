package com.zee.zee5_app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.zee.zee5_app.dto.Episode;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.repository.EpisodeRepository;
import com.zee.zee5_app.utils.DBUtils;

@Repository
public class EpisodeRepositoryImpl implements EpisodeRepository {
	
	private DBUtils dbUtils;
	public EpisodeRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addEpisode(Episode episode) {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		
		String insertStatement = "INSERT INTO episodes"
				+ " (epiId, seriesId, name, length, location)"
				+ " VALUES (?, ?, ?, ?, ?)";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, episode.getId());
			preparedStatement.setString(2, episode.getSerId());
			preparedStatement.setString(3, episode.getName());
			preparedStatement.setFloat(4, episode.getLength());
			preparedStatement.setString(5, episode.getLocation());
			
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
	public Optional<Episode> getEpisodeById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		String selectStatement = "SELECT * FROM episodes WHERE epiId=?";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Episode episode = new Episode();
				episode.setId(resultSet.getString("epiId"));
				episode.setSerId(resultSet.getString("seriesId"));
				episode.setName(resultSet.getString("name"));
				episode.setLength(resultSet.getFloat("length"));
				episode.setLocation(resultSet.getString("location"));
				return Optional.of(episode);
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
	public Episode[] getAllEpisode() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Optional<List<Episode>> optional = getAllEpisodeDetails();
		if(optional.isEmpty())
			return null;
		else {
			List<Episode> list = optional.get();
			Episode[] episodes = new Episode[list.size()];
			return list.toArray(episodes);
		}
	}

	@Override
	public String modifyEpisode(String id, Episode episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		
		String updateStatement = "UPDATE episodes"
				+ " SET epiId = ?, seriesId = ?, name = ?, length = ?, location = ?"
				+ " WHERE (epiId = ?)";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, episode.getId());
			preparedStatement.setString(2, episode.getSerId());
			preparedStatement.setString(3, episode.getName());
			preparedStatement.setFloat(4, episode.getLength());
			preparedStatement.setString(5, episode.getLocation());
			preparedStatement.setString(6, id);
			
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
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		
		String deleteStatement = "DELETE FROM episodes WHERE epiId=?";
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
	public Optional<List<Episode>> getAllEpisodeDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Episode> arrayList = new ArrayList<Episode>();
		
		String selectStatement = "SELECT * FROM episodes";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Episode episode = new Episode();
				episode.setId(resultSet.getString("epiId"));
				episode.setSerId(resultSet.getString("seriesId"));
				episode.setName(resultSet.getString("name"));
				episode.setLength(resultSet.getFloat("length"));
				episode.setLocation(resultSet.getString("location"));
				arrayList.add(episode);
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

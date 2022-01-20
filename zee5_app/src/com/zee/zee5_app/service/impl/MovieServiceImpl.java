package com.zee.zee5_app.service.impl;

import com.zee.zee5_app.dto.Movie;
import com.zee.zee5_app.repository.MovieRepository;
import com.zee.zee5_app.repository.impl.MovieRepositoryImpl;
import com.zee.zee5_app.service.MovieService;

public class MovieServiceImpl implements MovieService {
	
	private MovieRepository movieRepository = MovieRepositoryImpl.getInstance();
	private MovieServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static MovieService movieService;
	public static MovieService getInstance() {
		if(movieService==null)
			movieService = new MovieServiceImpl();
		return movieService;
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.addMovie(movie);
	}

	@Override
	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		return movieRepository.getMovieById(id);
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.getAllMovies();
	}

	@Override
	public String modifyMovie(String id, Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.modifyMovie(id, movie);
	}

	@Override
	public String deleteMovie(String id) {
		// TODO Auto-generated method stub
		return movieRepository.deleteMovie(id);
	}

}

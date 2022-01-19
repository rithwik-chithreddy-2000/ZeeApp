package com.zee.zee5_app.service;

import com.zee.zee5_app.dto.Movie;
import com.zee.zee5_app.repository.MovieRepository;

public class MovieService {
	
	private MovieRepository movieRepository = MovieRepository.getInstance();
	private MovieService() {
		// TODO Auto-generated constructor stub
	}
	
	public String addMovie(Movie movie) {
		return this.movieRepository.addMovie(movie);
	}
	
	public Movie getMovieById(String id) {
		return this.movieRepository.getMovieById(id);
	}
	
	public Movie[] getAllMovies() {
		return this.movieRepository.getAllMovies();
	}
	
	public String modifyMovie(String id, Movie movie) {
		return this.movieRepository.modifyMovie(id, movie);
	}
	
	public String deleteMovie(String id) {
		return this.movieRepository.deleteMovie(id);
	}
	
	private static MovieService movieService;
	public static MovieService getInstance() {
		if(movieService==null)
			movieService = new MovieService();
		return movieService;
	}

}

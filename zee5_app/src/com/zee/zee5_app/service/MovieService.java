package com.zee.zee5_app.service;

import com.zee.zee5_app.dto.Movie;

public interface MovieService {
	
	public String addMovie(Movie movie);
	public Movie getMovieById(String id);
	public Movie[] getAllMovies();
	public String modifyMovie(String id, Movie movie);
	public String deleteMovie(String id);

}

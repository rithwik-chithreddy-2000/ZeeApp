package com.zee.zee5_app.repository.impl;

import com.zee.zee5_app.dto.Movie;
import com.zee.zee5_app.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
	
	private Movie[] movies = new Movie[10];
	private static int movieCount = -1;
	private MovieRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static MovieRepository movieRepository;
	public static MovieRepository getInstance() {
		if(movieRepository==null)
			movieRepository = new MovieRepositoryImpl();
		return movieRepository;
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		if(movieCount==movies.length-1) {
			Movie temp[] = new Movie[movies.length*2];
			System.arraycopy(movies, 0, temp, 0, movies.length);
			movies = temp;
		}
		movies[++movieCount] = movie;
		return "Success";
	}

	@Override
	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		for (Movie movie : movies) {
			if(movie!=null && movie.getId().equals(id))
				return movie;
		}
		return null;
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		return movies;
	}

	@Override
	public String modifyMovie(String id, Movie movie) {
		// TODO Auto-generated method stub
		for (int i = 0; i < movies.length; i++) {
			if(movies[i].getId().equals(id)) {
				movies[i] = movie;
				return "Modified";
			}
		}
		return "Id does not exist";
	}

	@Override
	public String deleteMovie(String id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < movies.length; i++) {
			if(movies[i].getId().equals(id)) {
				System.arraycopy(movies, i+1, movies, i, movieCount-i);
				movies[movieCount--] = null;
				return "Deleted";
			}
		}
		return "Id does not exist";
	}

}

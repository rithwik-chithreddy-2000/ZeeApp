package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie addMovie(Movie movie) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(movieRepository.existsById(movie.getId())) {
			throw new AlreadyExistsException("This record already exists");
		}
		Movie movie2 = movieRepository.save(movie);
		return movie2;
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = movieRepository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Id does not exist");
		}
		return optional;
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		List<Movie> list = movieRepository.findAll();
		Movie[] movies = new Movie[list.size()];
		return list.toArray(movies);
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = this.getMovieById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			movieRepository.deleteById(id);
			return "Success";
		}
	}

	@Override
	public Optional<List<Movie>> getAllMovieDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}

}

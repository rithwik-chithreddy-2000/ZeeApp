package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

public interface SeriesService {
	
	public Series addSeries(Series series) throws AlreadyExistsException;
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException;
	public Series[] getAllSeries();
	public String deleteSeries(String id) throws IdNotFoundException;
	public Optional<List<Series>> getAllSeriesDetails();

}

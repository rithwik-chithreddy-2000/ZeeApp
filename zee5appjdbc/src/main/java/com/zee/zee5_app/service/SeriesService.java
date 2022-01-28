package com.zee.zee5_app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.exception.IdNotFoundException;

public interface SeriesService {
	
	public String addSeries(Series series);
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException;
	public Series[] getAllSeries();
	public String modifySeries(String id, Series series) throws IdNotFoundException;
	public String deleteSeries(String id) throws IdNotFoundException;
	public List<Series> getAllSeriesDetails();

}

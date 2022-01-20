package com.zee.zee5_app.service;

import com.zee.zee5_app.dto.Series;

public interface SeriesService {
	
	public String addSeries(Series series);
	public Series getSeriesById(String id);
	public Series[] getAllSeries();
	public String modifySeries(String id, Series series);
	public String deleteSeries(String id);

}

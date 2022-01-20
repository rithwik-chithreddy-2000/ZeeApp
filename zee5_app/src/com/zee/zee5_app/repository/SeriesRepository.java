package com.zee.zee5_app.repository;

import com.zee.zee5_app.dto.Series;

public interface SeriesRepository {
	
	public String addSeries(Series series);
	public Series getSeriesById(String id);
	public Series[] getAllSeries();
	public String modifySeries(String id, Series series);
	public String deleteSeries(String id);

}

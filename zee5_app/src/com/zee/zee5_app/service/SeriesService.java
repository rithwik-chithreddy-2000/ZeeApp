package com.zee.zee5_app.service;

import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.repository.SeriesRepository;

public class SeriesService {
	
	private SeriesRepository seriesRepository = SeriesRepository.getInstance();
	private SeriesService() {
		// TODO Auto-generated constructor stub
	}
	
	public String addSeries(Series series) {
		return this.seriesRepository.addSeries(series);
	}
	
	public Series getSeriesById(String id) {
		return this.seriesRepository.getSeriesById(id);
	}
	
	public Series[] getAllSeries() {
		return this.seriesRepository.getAllSeries();
	}
	
	public String modifySeries(String id, Series series) {
		return this.seriesRepository.modifySeries(id, series);
	}
	
	public String deleteSeries(String id) {
		return this.seriesRepository.deleteSeries(id);
	}
	
	private static SeriesService seriesService;
	public static SeriesService getInstance() {
		if(seriesService==null)
			seriesService = new SeriesService();
		return seriesService;
	}

}

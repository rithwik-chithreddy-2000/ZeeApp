package com.zee.zee5_app.service.impl;

import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.repository.SeriesRepository;
import com.zee.zee5_app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5_app.service.SeriesService;

public class SeriesServiceImpl implements SeriesService {
	
	private SeriesRepository seriesRepository = SeriesRepositoryImpl.getInstance();
	
	private SeriesServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static SeriesService seriesService;
	public static SeriesService getInstance() {
		if(seriesService==null)
			seriesService = new SeriesServiceImpl();
		return seriesService;
	}

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return seriesRepository.addSeries(series);
	}

	@Override
	public Series getSeriesById(String id) {
		// TODO Auto-generated method stub
		return seriesRepository.getSeriesById(id);
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeries();
	}

	@Override
	public String modifySeries(String id, Series series) {
		// TODO Auto-generated method stub
		return seriesRepository.modifySeries(id, series);
	}

	@Override
	public String deleteSeries(String id) {
		// TODO Auto-generated method stub
		return seriesRepository.deleteSeries(id);
	}

}

package com.zee.zee5_app.repository.impl;

import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.repository.SeriesRepository;

public class SeriesRepositoryImpl implements SeriesRepository {
	
	private Series[] seriesP = new Series[10];
	private static int seriesCount = -1;
	
	private SeriesRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static SeriesRepository seriesRepository;
	public static SeriesRepository getInstance() {
		if(seriesRepository==null)
			seriesRepository = new SeriesRepositoryImpl();
		return seriesRepository;
	}

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		if(seriesCount==seriesP.length-1) {
			Series temp[] = new Series[seriesP.length*2];
			System.arraycopy(seriesP, 0, temp, 0, seriesP.length);
			seriesP = temp;
		}
		seriesP[++seriesCount] = series;
		return "Success";
	}

	@Override
	public Series getSeriesById(String id) {
		// TODO Auto-generated method stub
		for (Series series : seriesP) {
			if(series!=null && series.getId().equals(id))
				return series;
		}
		return null;
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		return seriesP;
	}

	@Override
	public String modifySeries(String id, Series series) {
		// TODO Auto-generated method stub
		for (int i = 0; i < seriesP.length; i++) {
			if(seriesP[i].getId().equals(id)) {
				seriesP[i] = series;
				return "Modified";
			}
		}
		return "Id does not exist";
	}

	@Override
	public String deleteSeries(String id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < seriesP.length; i++) {
			if(seriesP[i].getId().equals(id)) {
				System.arraycopy(seriesP, i+1, seriesP, i, seriesCount-i);
				seriesP[seriesCount--] = null;
				return "Deleted";
			}
		}
		return "Id does not exist";
	}

}

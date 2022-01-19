package com.zee.zee5_app.repository;

import com.zee.zee5_app.dto.Series;

public class SeriesRepository {
	
	private Series[] seriesP = new Series[10];
	private static int seriesCount = -1;
	private SeriesRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public String addSeries(Series series) {
		if(seriesCount==seriesP.length-1) {
			Series temp[] = new Series[seriesP.length*2];
			System.arraycopy(seriesP, 0, temp, 0, seriesP.length);
			seriesP = temp;
		}
		seriesP[++seriesCount] = series;
		return "Success";
	}
	
	public Series getSeriesById(String id) {
		for (Series series : seriesP) {
			if(series!=null && series.getId().equals(id))
				return series;
		}
		return null;
	}
	
	public Series[] getAllSeries() {
		return seriesP;
	}
	
	public String modifySeries(String id, Series series) {
		for (int i = 0; i < seriesP.length; i++) {
			if(seriesP[i].getId().equals(id)) {
				seriesP[i] = series;
				return "Modified";
			}
		}
		return "Id does not exist";
	}
	
	public String deleteSeries(String id) {
		for (int i = 0; i < seriesP.length; i++) {
			if(seriesP[i].getId().equals(id)) {
				System.arraycopy(seriesP, i+1, seriesP, i, seriesCount-i);
				seriesP[seriesCount--] = null;
				return "Deleted";
			}
		}
		return "Id does not exist";
	}
	
	private static SeriesRepository seriesRepository;
	public static SeriesRepository getInstance() {
		if(seriesRepository==null)
			seriesRepository = new SeriesRepository();
		return seriesRepository;
	}

}

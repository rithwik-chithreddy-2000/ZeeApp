package com.zee.zee5_app.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.repository.SeriesRepository;

public class SeriesRepositoryImpl implements SeriesRepository {
	
	private TreeSet<Series> set = new TreeSet<Series>();
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
		boolean result = this.set.add(series);
		if(result)
			return "Success";
		return "Fail";
	}
	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Series series2 = null;
		for (Series series : set) {
			if(series.getId().equals(id)) {
				series2 = series;
				break;
			}
		}
		return Optional.of(Optional.ofNullable(series2).orElseThrow(() -> new IdNotFoundException("id not found")));
	}
	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		Series series[] = new Series[set.size()];
		return set.toArray(series);
	}
	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		String result = this.deleteSeries(id);
		if(result=="Failed")
			return "Failed";
		result = this.addSeries(series);
		if(result=="Fail")
			return "Failed";
		return "Updated";
		
	}
	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Series> optional = this.getSeriesById(id);
		boolean result = set.remove(optional.get());
		if(result)
			return "Deleted";
		return "Failed";
	}
	@Override
	public List<Series> getAllSeriesDetails() {
		// TODO Auto-generated method stub
		return new ArrayList<Series>(set);
	}

	

}

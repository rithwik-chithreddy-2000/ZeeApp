package com.zee.zee5_app.dto;

import lombok.Data;

@Data
public class Series {
	
	private String id;
	private String name;
	private String genre;
	private String releaseDate;
	private String trailer;
	private String language;
	private String[] cast;
	private int noOfSeasons;
	private int[] noOfEpisodes;

}

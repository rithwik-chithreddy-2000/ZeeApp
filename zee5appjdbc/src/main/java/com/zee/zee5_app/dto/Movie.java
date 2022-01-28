package com.zee.zee5_app.dto;

import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Movie implements Comparable<Movie>{
	
	public Movie(String id, String name, String genre, String releaseDate, String trailer, String language,
			String[] cast, float length)
					throws InvalidIdLengthException, InvalidNameException {
		super();
		this.setId(id);
		this.setName(name);
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.trailer = trailer;
		this.language = language;
		this.cast = cast;
		this.length = length;
	}
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	@Setter(value = AccessLevel.NONE)
	private String name;
	private String genre;
	private String releaseDate;
	private String trailer;
	private String language;
	private String[] cast;
	private float length;
	
	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6)
			throw new InvalidIdLengthException("id length is less than 6");
		this.id = id;
	}
	
	public void setName(String name) throws InvalidNameException {
		if(name==null || name=="" || name.length()<2)
			throw new InvalidNameException("name is not valid");
		this.name = name;
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, name, genre, releaseDate, trailer, language, cast, length);
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj)
//			return true;
//		if(obj == null)
//			return false;
//		if(getClass() != obj.getClass())
//			return false;
//		Movie other = (Movie) obj;
//		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
//				&& Objects.equals(genre, other.genre) && Objects.equals(releaseDate, other.releaseDate)
//				&& Objects.equals(trailer, other.trailer) && Objects.equals(language, other.language)
//				&& Objects.equals(cast, other.cast) && Objects.equals(length, other.length);
//	}
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}

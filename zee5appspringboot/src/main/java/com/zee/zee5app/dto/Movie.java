package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Entity
@Table(name = "movie", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Movie implements Comparable<Movie> {
	
	@Id
	@Column(name = "movId")
	private String id;
	@NotBlank
	private String name;
	@Max(value = 70)
	private int ageLimit;
	@NotBlank
	private String cast;
	@NotBlank
	private String genre;
	@NotNull
	private float length;
//	@Lob
//	private byte[] trailer;
	private String trailer;
	@NotBlank
	private String releaseDate;
	@NotBlank
	private String language;
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}

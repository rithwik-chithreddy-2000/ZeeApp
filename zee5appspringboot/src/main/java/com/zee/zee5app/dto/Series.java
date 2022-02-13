package com.zee.zee5app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "series", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Series implements Comparable<Series> {
	
	@Id
	@Column(name = "serId")
	private String id;
	@NotBlank
	private String name;
	@Max(value = 70)
	private int ageLimit;
	private String trailer;
	@NotBlank
	private String cast;
	@NotBlank
	private String genre;
	@NotNull
	private String releaseDate;
	@NotBlank
	private String language;
	@Min(value = 1)
	private int noOfEpisodes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "series", cascade = CascadeType.ALL)
	private List<Episode> episodes = new ArrayList<Episode>();
	
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}

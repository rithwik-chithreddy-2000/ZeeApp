package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

public interface EpisodeService {
	
	public Episode addEpisode(Episode episode) throws AlreadyExistsException;
	public Optional<Episode> getEpisodeById(String id) throws IdNotFoundException;
	public Episode[] getAllEpisode();
	public String deleteEpisode(String id) throws IdNotFoundException;
	public Optional<List<Episode>> getAllEpisodeDetails();

}

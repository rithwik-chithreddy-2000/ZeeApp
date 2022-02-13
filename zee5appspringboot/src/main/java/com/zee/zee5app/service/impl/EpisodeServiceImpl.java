package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {
	
	@Autowired
	private EpisodeRepository episodeRepository;

	@Override
	public Episode addEpisode(Episode episode) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(episodeRepository.existsById(episode.getId())) {
			throw new AlreadyExistsException("This record already exists");
		}
		Episode episode2 = episodeRepository.save(episode);
		return episode2;
	}

	@Override
	public Optional<Episode> getEpisodeById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Episode> optional = episodeRepository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Id does not exist");
		}
		return optional;
	}

	@Override
	public Episode[] getAllEpisode() {
		// TODO Auto-generated method stub
		List<Episode> list = episodeRepository.findAll();
		Episode[] episodes = new Episode[list.size()];
		return list.toArray(episodes);
	}

	@Override
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Episode> optional = this.getEpisodeById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			episodeRepository.deleteById(id);
			return "Success";
		}
	}

	@Override
	public Optional<List<Episode>> getAllEpisodeDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodeRepository.findAll());
	}

}

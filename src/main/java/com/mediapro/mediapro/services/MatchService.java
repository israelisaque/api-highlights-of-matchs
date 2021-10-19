package com.mediapro.mediapro.services;

import com.mediapro.mediapro.dto.MatchDTO;
import com.mediapro.mediapro.mappers.CompetitionMapper;
import com.mediapro.mediapro.model.Competition;
import com.mediapro.mediapro.model.Match;
import com.mediapro.mediapro.model.Video;
import com.mediapro.mediapro.repositories.MatchRepository;
import com.mediapro.mediapro.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ExternalAPIService externalAPIService;


    @Transactional()
    @Cacheable(value = "matches")
    public List<MatchDTO> findAllMatchesByIdCompetition(Long id) {
        externalAPIService.persistenceAPIToEntities();

        List<Match> list = matchRepository.findAllByCompetition_Id(id);

        if (!list.isEmpty()) {
            return list
                       .stream()
                       .map(match -> new MatchDTO(match))
                       .collect(Collectors.toList());

        } else {
            throw new ResourceNotFoundException("Resource not found");
        }
    }


    public void saveMatch(CompetitionMapper compDTO, Competition competition, List<Video> videos) {
        Match match = new Match();

        match.setTitle(compDTO.getTitle());
        match.setCompetition(competition);
        match.setMatchviewUrl(compDTO.getMatchviewUrl());
        match.setCompetitionUrl(compDTO.getCompetitionUrl());
        match.setThumbnail(compDTO.getThumbnail());
        match.setDate(convertDate(compDTO.getDate()));
        match.setVideos(videos);

        matchRepository.save(match);
    }

    private LocalDateTime convertDate(String str) {
        LocalDateTime result = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ"));
        return result;
    }
}

package com.mediapro.mediapro.services;

import com.mediapro.mediapro.dto.VideoDTO;
import com.mediapro.mediapro.mappers.CompetitionMapper;
import com.mediapro.mediapro.model.Match;
import com.mediapro.mediapro.model.Video;
import com.mediapro.mediapro.repositories.MatchRepository;
import com.mediapro.mediapro.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ExternalAPIService externalAPIService;


    @Transactional()
    @Cacheable("videos")
    public VideoDTO findAllVideosByIdCompetitionAndIdMatch(Long idCompetition, Long idMatch) {
        externalAPIService.persistenceAPIToEntities();

        try {
            Match match = matchRepository.findByIdAndCompetition_Id(idMatch, idCompetition);
            return new VideoDTO(match);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    public List<Video> saveVideo(CompetitionMapper compDTO) {
        List<Video> videos = new ArrayList<>();
        compDTO.getVideos().stream().forEach(vdDTO -> {
            Video video = new Video();
            video.setTitle(vdDTO.getTitle());
            video.setEmbed(vdDTO.getEmbed());
            videos.add(video);
        });
        return videos;
    }
}

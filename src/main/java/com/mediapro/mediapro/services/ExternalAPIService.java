package com.mediapro.mediapro.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mediapro.mediapro.mappers.CompetitionMapper;
import com.mediapro.mediapro.model.Competition;
import com.mediapro.mediapro.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ExternalAPIService {

    @Value("${ApiUrl}")
    private String URL;

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private MatchService matchService;

    @Autowired
    private VideoService videoService;

    @Cacheable(value = "persistenceAPI")
    public void persistenceAPIToEntities() {
        List<CompetitionMapper> competitionList = reqAPIConverterFromJsonToList(URL);

        competitionList.stream().forEach(compDTO -> {
            Competition competition = competitionService.saveCompetition(compDTO);
            List<Video> videos = videoService.saveVideo(compDTO);
            matchService.saveMatch(compDTO, competition, videos);
        });
    }

    public List<CompetitionMapper> reqAPIConverterFromJsonToList(String URL) {
        RestTemplate client = new RestTemplate();
        ResponseEntity<String> response = client.getForEntity(URL, String.class);

        Gson gson = new Gson();
        JsonObject convertedObject = new Gson().fromJson(response.getBody(), JsonObject.class);

        List<CompetitionMapper> competitionList = Arrays.asList(gson.fromJson(convertedObject.get("response"), CompetitionMapper[].class));
        return competitionList;
    }
}

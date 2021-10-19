package com.mediapro.mediapro.controllers;

import com.mediapro.mediapro.dto.VideoDTO;
import com.mediapro.mediapro.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/highlight/competition/{idCompetition}/match/{idMatch}")
    public ResponseEntity<VideoDTO> findAllVideosByIdCompetitionAndIdMatch(@PathVariable Long idCompetition, @PathVariable Long idMatch) {
        VideoDTO obj = videoService.findAllVideosByIdCompetitionAndIdMatch(idCompetition, idMatch);
        return ResponseEntity.ok().body(obj);
    }
}

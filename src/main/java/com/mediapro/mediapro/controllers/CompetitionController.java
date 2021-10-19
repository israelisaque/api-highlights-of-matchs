package com.mediapro.mediapro.controllers;

import com.mediapro.mediapro.dto.CompetitionDTO;
import com.mediapro.mediapro.services.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping
    public ResponseEntity<List<CompetitionDTO>> findAllCompetitions() {
        List<CompetitionDTO> list = competitionService.findAllCompetitions();
        return ResponseEntity.ok().body(list);
    }
}

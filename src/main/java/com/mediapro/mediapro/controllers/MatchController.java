package com.mediapro.mediapro.controllers;

import com.mediapro.mediapro.dto.MatchDTO;
import com.mediapro.mediapro.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/match/{id}")
    public ResponseEntity<List<MatchDTO>> findAllPartidas(@PathVariable Long id) {
        List<MatchDTO> list = matchService.findAllMatchesByIdCompetition(id);
        return ResponseEntity.ok().body(list);
    }
}

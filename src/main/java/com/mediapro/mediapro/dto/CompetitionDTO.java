package com.mediapro.mediapro.dto;

import com.mediapro.mediapro.model.Competition;

import java.io.Serializable;

public class CompetitionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String competition;

    public CompetitionDTO() {
    }

    public CompetitionDTO(Competition competition) {
        this.id = competition.getId();
        this.competition = competition.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }
}

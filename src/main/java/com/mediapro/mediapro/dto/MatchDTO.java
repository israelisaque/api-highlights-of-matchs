package com.mediapro.mediapro.dto;

import com.mediapro.mediapro.model.Match;

public class MatchDTO {

    private Long id;
    private String highlight_title;

    public MatchDTO() {
    }

    public MatchDTO(Match match) {
        this.id = match.getId();
        this.highlight_title = match.getTitle();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHighlight_title() {
        return highlight_title;
    }

    public void setHighlight_title(String highlight_title) {
        this.highlight_title = highlight_title;
    }
}

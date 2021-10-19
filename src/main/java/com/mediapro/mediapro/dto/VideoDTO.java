package com.mediapro.mediapro.dto;

import com.mediapro.mediapro.model.Match;

import java.util.List;
import java.util.stream.Collectors;

public class VideoDTO {

    private String competition;
    private String highlight_title;
    private String thumbnail_url;
    private List<String> highlight_embed;

    public VideoDTO() {
    }

    public VideoDTO(Match match) {
        this.competition = match.getCompetition().getName();
        this.highlight_title = match.getTitle();
        this.thumbnail_url = match.getThumbnail();
        this.highlight_embed = match
                .getVideos()
                .stream()
                .map(video -> video.getEmbed())
                .collect(Collectors.toList());
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getHighlight_title() {
        return highlight_title;
    }

    public void setHighlight_title(String highlight_title) {
        this.highlight_title = highlight_title;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public List<String> getHighlight_embed() {
        return highlight_embed;
    }

    public void setHighlight_embed(List<String> highlight_embed) {
        this.highlight_embed = highlight_embed;
    }
}

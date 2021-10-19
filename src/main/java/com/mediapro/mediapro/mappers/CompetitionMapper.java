package com.mediapro.mediapro.mappers;

import java.util.List;

public class CompetitionMapper {

    private String title;
    private String competition;
    private String matchviewUrl;
    private String competitionUrl;
    private String thumbnail;
    private String date;

    private List<VideoMapper> videos;

    public CompetitionMapper() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getMatchviewUrl() {
        return matchviewUrl;
    }

    public void setMatchviewUrl(String matchviewUrl) {
        this.matchviewUrl = matchviewUrl;
    }

    public String getCompetitionUrl() {
        return competitionUrl;
    }

    public void setCompetitionUrl(String competitionUrl) {
        this.competitionUrl = competitionUrl;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<VideoMapper> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoMapper> videos) {
        this.videos = videos;
    }
}

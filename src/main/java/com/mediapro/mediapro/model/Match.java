package com.mediapro.mediapro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Match implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne()
    private Competition competition;
    private String matchviewUrl;
    private String competitionUrl;
    private String thumbnail;
    private LocalDateTime date;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Video> videos;

    public Match() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

}


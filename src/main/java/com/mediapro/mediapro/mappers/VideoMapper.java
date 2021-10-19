package com.mediapro.mediapro.mappers;

import javax.persistence.Column;

public class VideoMapper {

    private String title;
    private String embed;

    public VideoMapper() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }
}

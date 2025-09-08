package com.yt2sp.converter.PlaylistConverter.models;

import lombok.Data;

@Data
public class Tracks {

    private String id;

    private String title;

    private String artist;

    private String album;
    private long duration;
    private String sourceURL;
}

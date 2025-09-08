package com.yt2sp.converter.PlaylistConverter.models;

import lombok.Data;

@Data
public class ConversionStatus {
    enum status {
        IN_PROGRESS,SUCCESS,FAILED,PARTIAL;
    }

    private int totalTracks;
    private int succeeded;
    private int failed;
    private String message;


}

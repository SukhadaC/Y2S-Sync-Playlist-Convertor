package com.yt2sp.converter.PlaylistConverter.models;


import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;


@Data
public class Playlist {
    private String id;
    private String name;
    private String description;

    @OneToMany
    private List<Tracks> tracksList;
    private String imageUrl;


}

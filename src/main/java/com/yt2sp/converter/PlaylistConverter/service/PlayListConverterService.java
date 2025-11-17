package com.yt2sp.converter.PlaylistConverter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yt2sp.converter.PlaylistConverter.adapter.SpotifyAPIAdapter;
import com.yt2sp.converter.PlaylistConverter.adapter.YoutubeAPIAdapter;
import com.yt2sp.converter.PlaylistConverter.models.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayListConverterService {

    @Autowired
    private YoutubeAPIAdapter youtubeAPIAdapter;

    @Autowired
    private SpotifyAPIAdapter spotifyAPIAdapter;

    public Playlist  convertYoutubeToSpotify(String  playlistId) throws JsonProcessingException {

       Playlist playlist= youtubeAPIAdapter.fetchPlaylist(playlistId);

        Playlist spotifyPlsyList=spotifyAPIAdapter.createPlayList(playlist);

    return playlist;
    }
}

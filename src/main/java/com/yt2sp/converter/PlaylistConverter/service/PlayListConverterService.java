package com.yt2sp.converter.PlaylistConverter.service;

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

    public void  convertYoutubeToSpotify(long playlistId) {

        youtubeAPIAdapter.fetchPlaylist(playlistId);


    }
}

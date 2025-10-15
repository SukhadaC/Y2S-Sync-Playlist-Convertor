package com.yt2sp.converter.PlaylistConverter.controller;

import com.yt2sp.converter.PlaylistConverter.models.ConversionStatus;
import com.yt2sp.converter.PlaylistConverter.models.Playlist;
import com.yt2sp.converter.PlaylistConverter.service.PlayListConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/convert")
public class PlayListConverterController {


    private PlayListConverterService playlistConvertorService;

    @Autowired
    public PlayListConverterController(PlayListConverterService playListConverterService)
    {
        this.playlistConvertorService=playListConverterService;
    }


    @PostMapping("/yt-2-spotify")
    public ResponseEntity<Playlist> convertYt2SpoityfyPlaylist(long playlistId)
    {
        playlistConvertorService.convertYoutubeToSpotify(playlistId);

        return null;
    }








}

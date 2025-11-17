package com.yt2sp.converter.PlaylistConverter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yt2sp.converter.PlaylistConverter.models.ConversionStatus;
import com.yt2sp.converter.PlaylistConverter.models.Playlist;
import com.yt2sp.converter.PlaylistConverter.service.PlayListConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayListConverterController {


    private PlayListConverterService playlistConvertorService;

    @Autowired
    public PlayListConverterController(PlayListConverterService playListConverterService)
    {
        this.playlistConvertorService=playListConverterService;
    }



     @GetMapping("/")
     public String returnHome()
     {
         return "homepage";
     }


    @GetMapping("/login")
    public String home()
    {
        return "login";
    }


    @PostMapping("/yt-2-spotify")
    public ResponseEntity<Playlist> convertYt2SpoityfyPlaylist(String  playlistId) throws JsonProcessingException {
        Playlist playlist=playlistConvertorService.convertYoutubeToSpotify(playlistId);

        return null;
    }








}

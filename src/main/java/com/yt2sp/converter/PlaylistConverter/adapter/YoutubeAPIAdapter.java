package com.yt2sp.converter.PlaylistConverter.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yt2sp.converter.PlaylistConverter.models.Playlist;
import com.yt2sp.converter.PlaylistConverter.models.Tracks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class YoutubeAPIAdapter {

    @Value("${youtube.api.key}")
    private String API_KEY;
    private static final String youtubeURL= "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet,contentDetails&maxResults=50&playlistId=%s&key=%s";
    public Playlist fetchPlaylist(String  playlistId) throws JsonProcessingException {

            String url= String.format(youtubeURL,playlistId,API_KEY);

        RestTemplate restTemplate=new RestTemplate();
       String response= restTemplate.getForObject(url,String.class);


       ObjectMapper mapper=new ObjectMapper();

        JsonNode root=mapper.readTree(response);


       Playlist playlist=new Playlist();

       List<Tracks> tracksList=new ArrayList<>();

       for(JsonNode item:root.path("snippet"))
       {
           Tracks  track=new Tracks();
           JsonNode snippet = item.path("snippet");

           track.setTitle(snippet.path("title").asText());
           track.setVideoId(snippet.path("resourceId").asText());

           track.setSourceURL(snippet.path("thumbnails").path("default").path("url").asText());

           track.setArtist(snippet.path("videoOwnerChannelTitle").asText());


           tracksList.add(track);

       }

       playlist.setTracksList(tracksList);
       playlist.setId(playlistId);

return playlist;
    }
}

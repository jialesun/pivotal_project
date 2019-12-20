package com.example.prftmgmt;


import com.example.prftmgmt.timesheetsui.MovieClient;
import com.example.prftmgmt.timesheetsui.MoviesInitialList;
import com.example.prftmgmt.ticketsui.PodcastClient;
import com.example.prftmgmt.ticketsui.PodcastsInitialList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {
    private MovieClient movieClient;
    private PodcastClient podcastClient;
    //private PodcastRepository podcastRepository;
    private MoviesInitialList moviesInitialList;
    private PodcastsInitialList podcastsInitialList;

    public RootController(MovieClient movieClient, PodcastClient podcastClient, MoviesInitialList moviesInitialList, PodcastsInitialList podcastsInitialList) {
        this.movieClient = movieClient;
        this.podcastClient = podcastClient;
        this.moviesInitialList = moviesInitialList;
        this.podcastsInitialList = podcastsInitialList;
    }

    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {

        moviesInitialList.asList().forEach(movieClient::create);
        model.put("movies", movieClient.getAll());

        podcastsInitialList.asList().forEach(podcastClient::create);
        model.put("podcasts", podcastClient.getAll());


        return "setup";
    }

}
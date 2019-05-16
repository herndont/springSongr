package com.example.songr.controllers;


import com.example.songr.database.Album;
import com.example.songr.database.Song;
import com.example.songr.database.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    SongRepository repoSong;


    @PostMapping("/create")
    public ModelAndView createSong(
            @RequestParam String title,
            @RequestParam String length,
            @RequestParam String trackNumber,
            @RequestParam String albumID

    ) {
        Song song = new Song();
        song.title = title;
        song.length = Long.parseLong(length);
        song.trackNumber = Integer.parseInt(trackNumber);
        song.albumID = Long.parseLong(albumID);

        repoSong.save(song);
        return new ModelAndView("redirect:/albums/" + albumID);
    }
}

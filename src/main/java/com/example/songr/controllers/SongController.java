package com.example.songr.controllers;


import com.example.songr.database.Song;
import com.example.songr.database.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    SongRepository repoSong;


//    @GetMapping("")
//    public String getSongs(Model model) {
//
//    }



//    @GetMapping("")
//    public String getAlbums(Model model){
//        Album album = new Album();
//        album.title = "Led Zeppelin III";
//        album.artist = "Led Zeppelin";
//        album.songCount = 10;
//        album.length = 2588;
//        album.imageURL = "https://en.wikipedia.org/wiki/Led_Zeppelin_III#/media/File:Led_Zeppelin_-_Led_Zeppelin_III.png";
//
//        this.repoAlbum.save(album);
////        Returns all the albums including the new one
//        List<Album> albums = (List<Album>) this.repoAlbum.findAll();
//
//        model.addAttribute(albums);
//
//        return "albums";
//    }
}

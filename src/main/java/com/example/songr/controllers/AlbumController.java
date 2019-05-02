package com.example.songr.controllers;

import com.example.songr.database.Album;
import com.example.songr.database.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumRepository repo;

    @GetMapping("/")
    public Iterable<Album> getAlbums(){
        Album album = new Album();
        album.title = "Led Zeppelin III";
        album.artist = "Led Zeppelin";
        album.songCount = 10;
        album.length = 2588;
        album.imageURL = "https://en.wikipedia.org/wiki/Led_Zeppelin_III#/media/File:Led_Zeppelin_-_Led_Zeppelin_III.png";

        this.repo.save(album);

        Iterable<Album> albums = this.repo.findAll();

        return albums;
    }
}

package com.example.songr.controllers;

import com.example.songr.AlbumNotFoundException;
import com.example.songr.database.Album;
import com.example.songr.database.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumRepository repo;

    @GetMapping("/")
    public String getAlbums(Model model){
        List<Album> albums = (List<Album>) this.repo.findAll();
        model.addAttribute("albums", albums);


        Album album = new Album();
        album.title = "Led Zeppelin III";
        album.artist = "Led Zeppelin";
        album.songCount = 10;
        album.length = 2588;
        album.imageURL = "https://en.wikipedia.org/wiki/Led_Zeppelin_III#/media/File:Led_Zeppelin_-_Led_Zeppelin_III.png";

        this.repo.save(album);
        //Returns all the albums including the new one

        return "albums";
    }

//    @GetMapping("/album/{id}")
//    public Album getAlbum(@PathVariable Long id) {
//    //Getting the Album by id
//        Optional<Album> album = this.repo.findById(id);
//        if (album.isPresent()) {
//            //return value of Album Optional
//            return album.get();
//        } else {
//            throw new AlbumNotFoundException();
//        }
//    }
//
//    @PostMapping("/album")
//    public Album createAlbum(@RequestBody Album album){
//        album = this.repo.save(album);
//        return album;
//    }

//    @PutMapping("/album/{id}")
//    public Album updateAlbum(@PathVariable Long id, @RequestBody Album album) {
//        //Make sure the album exists and make sure they are not passing something we don't want in.
//        //We don't want to save something bad
//        Optional<Album> repoAlbum = this.repo.findById(id);
//        if (repoAlbum.isPresent()) {
//            Album foundAlbum = repoAlbum.get();
//
//            foundAlbum.title = album.title;
//            foundAlbum.artist = album.artist;
//            foundAlbum.songCount = album.songCount;
//            foundAlbum.length = album.length;
//            foundAlbum.imageURL = album.imageURL;
//
//            foundAlbum = this.repo.save(foundAlbum);
//            return foundAlbum;
//        }
//        throw new AlbumNotFoundException();
//    }
//
//    @DeleteMapping("/album/{id}")
//    public void deleteAlbum(@PathVariable Long id) {
//        this.repo.deleteById(id);
//    }
}

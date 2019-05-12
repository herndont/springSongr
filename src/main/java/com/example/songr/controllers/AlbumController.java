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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    AlbumRepository repoAlbum;

    @GetMapping("")
    public String getAlbums(Model model){
        Album album = new Album();
        album.title = "Led Zeppelin III";
        album.artist = "Led Zeppelin";
        album.songCount = 10;
        album.length = 2588;
        album.imageURL = "https://en.wikipedia.org/wiki/Led_Zeppelin_III#/media/File:Led_Zeppelin_-_Led_Zeppelin_III.png";

        this.repoAlbum.save(album);
//        Returns all the albums including the new one
        List<Album> albums = (List<Album>) this.repoAlbum.findAll();

        model.addAttribute(albums);

        return "albums";
    }

    @GetMapping("/{id}")
    public String getAlbum(@PathVariable Long id, Model model) {
    //Getting the Album by id
        Optional<Album> album = this.repoAlbum.findById(id);
        if (album.isPresent()) {
            //return value of Album Optional
            model.addAttribute("album", album);
            return "singleAlbum";
        } else {
            throw new AlbumNotFoundException();
        }
    }

    @PostMapping("/create")
    public RedirectView createAlbum(
            @RequestParam String title,
            @RequestParam String artist,
            @RequestParam String songCount,
            @RequestParam String length,
            @RequestParam String imageURL
    ) {
        Album album = new Album();
        album.title = title;
        album.artist = artist;
        album.songCount = Integer.parseInt(songCount);
        album.length = Long.parseLong(length);
        album.imageURL = imageURL;

        repoAlbum.save(album);
        return new RedirectView("") ;
    }

    @PutMapping("/{id}")
    public Album updateAlbum(@PathVariable Long id, @RequestBody Album album) {
        //Make sure the album exists and make sure they are not passing something we don't want in.
        //We don't want to save something bad
        Optional<Album> repoAlbum = this.repoAlbum.findById(id);
        if (repoAlbum.isPresent()) {
            Album foundAlbum = repoAlbum.get();

            foundAlbum.title = album.title;
            foundAlbum.artist = album.artist;
            foundAlbum.songCount = album.songCount;
            foundAlbum.length = album.length;
            foundAlbum.imageURL = album.imageURL;

            foundAlbum = this.repoAlbum.save(foundAlbum);
            return foundAlbum;
        }
        throw new AlbumNotFoundException();
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable Long id) {
        this.repoAlbum.deleteById(id);
    }
}

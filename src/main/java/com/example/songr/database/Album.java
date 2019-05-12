package com.example.songr.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Album {

    @Id
    @GeneratedValue
    public long id;

    public String title;
    public String artist;
    public int songCount;
    public long length;  //album length in seconds
    public String imageURL;  //URL to image art
}

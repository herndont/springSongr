package com.example.songr.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Song {
        @Id
        @GeneratedValue
        public long id;

        public String title;
        public Long length;  //in seconds
        public int trackNumber;
        public long albumID;
}

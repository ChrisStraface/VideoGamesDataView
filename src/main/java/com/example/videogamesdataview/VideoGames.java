package com.example.videogamesdataview;

import java.io.Serializable;
import java.util.ArrayList;

public class VideoGames implements Serializable {
    public static ArrayList<VideoGames> allVideoGames = new ArrayList<>();
     String name;
     String platform;
     String releaseDate;

    VideoGames(String name, String platform, String releaseDate) {
        this.name = name;
        this.platform = platform;
        this.releaseDate = releaseDate;
        allVideoGames.add(this);
    }

    public static ArrayList<VideoGames> getAllVideoGames() {
        return allVideoGames;
    }

    public static void setAllVideoGames(ArrayList<VideoGames> allVideoGames) {
        VideoGames.allVideoGames = allVideoGames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    void describeSelf(){
        System.out.println("I am a video game I have a " + name + ", a " + platform + "and a " + releaseDate);
    }

}

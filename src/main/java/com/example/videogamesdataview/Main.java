package com.example.videogamesdataview;

public class Main {
    public static void main(String[] args) {
        VideogamesSells.readAllData();

        VideoGameScore.readAllData();
        for(VideoGames game: VideoGames.getAllVideoGames()) {
            System.out.println(game);
       }
    }

}


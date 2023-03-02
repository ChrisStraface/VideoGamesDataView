package com.example.videogamesdataview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VideoGameScore extends VideoGames {

    private int rank;
    private int score;

    VideoGameScore(String name, String platform, String releaseDate, int rank, int score) {
        super(name, platform, releaseDate);
        this.rank = rank;
        this.score = score;
    }

    private int getRank() {
        return rank;
    }

    private void setRank(int rank) {
        this.rank = rank;
    }

    private int getScore() {
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return name + ", " + platform + ", " + releaseDate + ", ranked" + rank + ", score of " + score;
    }

    void describeSelf() {
        System.out.println(name + ", " + platform + ", " + releaseDate + ", ranked " + rank + ", score of " + score);
    }

    static void readAllData() {
        Scanner sc = null;
        try {
            File file = new File("src/Videogamescoresdata");
            sc = new Scanner(file);
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                System.out.println(line);
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("\t");
                int rank = lineScanner.nextInt();
                String name = lineScanner.next();
                String platform = lineScanner.next();
                String releaseDate = lineScanner.next();
                int score = lineScanner.nextInt();
                new VideoGameScore(name,platform,releaseDate,rank,score);
            }
            }
        catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
        finally{
                if (sc != null) sc.close();
            }
        }
    }


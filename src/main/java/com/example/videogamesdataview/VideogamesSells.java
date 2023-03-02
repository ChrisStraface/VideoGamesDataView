package com.example.videogamesdataview;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public class VideogamesSells extends VideoGames implements Serializable {

    String developer;
    String publisher;
    String series;
    int sales;
    public VideogamesSells(String name, String platform, String releaseDate, String developer, String publisher, String series, int sales) {
        super(name, platform, releaseDate);
        this.developer = developer;
        this.publisher = publisher;
        this.series = series;
        this.sales = sales;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public  String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String toString()
    {
        return name + ", " + platform + ", " + releaseDate + ", " + developer + ", " + publisher + ", " + series + ", " + sales;
    }

    void describeSelf() {
        System.out.println(name + ", " + platform + ", " + releaseDate + ", " + developer + ", " + publisher + ", " + series + ", " + sales);
    }
    static void readAllData() {
        Scanner sc = null;
        try{
            File file = new File("Video game sales data");
            sc = new Scanner(file);
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                System.out.println(line);
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("\t");
                String name = lineScanner.next();
                int sales = lineScanner.nextInt();
                String series = lineScanner.next();
                String platform = lineScanner.next();
                String releaseDate = lineScanner.next();
                String developer = lineScanner.next();
                String publisher = lineScanner.next();
                new VideogamesSells(name, platform, releaseDate, developer, publisher, series, sales);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            if (sc != null) sc.close();
        }
    }
}


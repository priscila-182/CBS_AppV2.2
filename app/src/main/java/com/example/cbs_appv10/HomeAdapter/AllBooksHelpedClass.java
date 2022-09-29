package com.example.cbs_appv10.HomeAdapter;

public class AllBooksHelpedClass {

    int image;
    String title, author, genre, desc, score;

    public AllBooksHelpedClass(int image, String title, String author, String genre, String desc, String score) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.desc = desc;
        this.score = score;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getDesc() {
        return desc;
    }

    public String getScore() {
        return score;
    }
}

package com.example.cbs_appv10.HomeAdapter;

public class MostViewedCardDesignHelpedClass {

    int image, rating;
    String title, description, autor, genero;

    public MostViewedCardDesignHelpedClass(int image, int rating, String title, String description, String autor, String genero) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.autor = autor;
        this.genero = genero;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getRating() {
        return rating;
    }
}

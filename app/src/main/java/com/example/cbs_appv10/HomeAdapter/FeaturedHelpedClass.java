package com.example.cbs_appv10.HomeAdapter;

public class FeaturedHelpedClass {

    int image;
    String title, description, autor, genero;

    public FeaturedHelpedClass(int image, String title, String description, String autor, String genero) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.autor = autor;
        this.genero = genero;
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

}

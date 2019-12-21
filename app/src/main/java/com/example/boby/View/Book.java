package com.example.boby.View;

public class Book {

    private String title;
    private String categories;
    private String shortDescription;
    private String thumbnailUrl;

    public Book() {
    }

    public Book(String title,String categories,String shortDescription, String thumbnailUrl){
        this.title = title;
        this.categories = categories;
        this.shortDescription = shortDescription;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {return title;}
    public String getCategories() {return categories;}
    public String getShortDescription() {return shortDescription;}
    public String getThumbnailUrl() {return thumbnailUrl;}

    public void setTitle(String title){this.title = title;}
    public void setCategory(String categories){this.categories = categories;}
    public void setShortDescription(String shortDescription){this.shortDescription = shortDescription;}
    public void setThumbnailUrl(String thumbnailUrl){this.thumbnailUrl = thumbnailUrl; }


}

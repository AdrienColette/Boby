package com.example.boby.Model;

public class Book {

    private String title;
    private String status;
    private String longDescription;
    private String thumbnailUrl;

    public Book() {
    }

    public Book (String title, String status, String longDescription, String thumbnailUrl){

        this.title = title;
        this.status = status;
        this.longDescription = longDescription;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {return title;}
    public String getStatus() {return status;}
    public String getLongDescription() {return longDescription;}
    public String getThumbnailUrl() {return thumbnailUrl;}

    public void setTitle(String title){this.title = title;}
    public void setStatus(String status){this.status = status;}
    public void setLongDescription(String longDescription){this.longDescription = longDescription;}
    public void setThumbnailUrl(String thumbnailUrl){this.thumbnailUrl = thumbnailUrl; }


}

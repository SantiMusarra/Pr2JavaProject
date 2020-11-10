package com.MusarraSanti.Code;

import com.MusarraSanti.Exception.ExceededCharactersLimitException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post implements BasePost {

    private int id;
    private String author;
    private String text;
    private String timestamp;
    private List likes;


    /*
    REQUIRES: id >= 0 && author != null && text != null
    THROWS: if id < 0 throws IllegalArgumentException
            if author == null throws NullPointerException
            if text == null throws NullPointerException
            if text.length > 140 throws ExceededCharactersLimit
    MODIFIES: this
    EFFECTS: Initialize this < id , author , text >

     */
    public  Post( int id, String author , String text ) throws ExceededCharactersLimitException {

        if(id < 0) throw new IllegalArgumentException();
        if(author == null)  throw new NullPointerException();
        if(text == null) throw  new NullPointerException();
        if(text.length() > 140 ) throw new ExceededCharactersLimitException();

        this.id = id;
        this.author = author;
        this.text = text;
        this.timestamp = setTimeStamp();
        this.likes = new ArrayList();
    }

    public int getID() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getText() {
        return this.text;
    }

    public String setTimeStamp() {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return dateFormat.format(date);

    }

    public String getTimeStamp() {
        return this.timestamp;
    }

    public void addLike(String User) {

    }

    public List getLikes() {
        return this.likes;
    }

    public String toString(){

        return ("Post id : " + this.id + "\nUser: " + this.author + "\nPost Text: " + this.text + "\nOra e data del post: " + this.timestamp + "\nPost Likes: " + this.likes.toString());
    }
}



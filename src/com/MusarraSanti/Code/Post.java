package com.MusarraSanti.Code;

import com.MusarraSanti.Exception.ExceededCharactersLimitException;

import javax.print.MultiDocPrintService;
import java.text.SimpleDateFormat;
import java.util.*;

public class Post implements BasePost {

    private int id;
    private String author;
    private String text;
    private String timestamp;
    private List likes;



    /*
    REQUIRES: id >= 0 && author != null && text != null
    THROWS: if id < 0 throws IllegalArgumentException   (unchecked)
            if author == null throws NullPointerException   (unchecked)
            if text == null throws NullPointerException     (unchecked)
            if text.length > 140 throws ExceededCharactersLimit     (checked)
    MODIFIES: this
    EFFECTS: Initialize this < id , author , text >
     */
    public  Post( int id, String author , String text ) throws ExceededCharactersLimitException {

        if(id < 0) throw new IllegalArgumentException("Id is negative");
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
        if(User == null) throw new NullPointerException();
        else{
            if(this.likes.contains(User))throw new IllegalArgumentException("You cannot like the post twice");
            this.likes.add(User);
        }
    }

    public List getLikes() {
        return this.likes;
    }

    public String toString(){

        return ("Post id : " + this.id + "\nUser: " + this.author + "\nPost Text: " + this.text + "\nDate published: " + this.timestamp
                    + "\nPost Likes: " + this.likes.size() + "\nPeople who liked the post :" + this.likes.toString());
    }
}



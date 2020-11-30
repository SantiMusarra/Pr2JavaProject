package com.MusarraSanti.Code;

import com.MusarraSanti.Exception.ExceededCharactersLimitException;

import java.text.SimpleDateFormat;
import java.util.*;

public class Post implements BasePost {

    //OVERVIEW: Descrive il tipo di dato Post con un id , un testo , un autore
    //          una data di pubblicazione e una lista di like
    //TYPICAL ELEMENT: <id , author , text , timestamp , {x,...,xn} >

    //TODO Abstraction function:

    //TODO Invariant representation:


    public static final int CHARACTERS_LIMIT = 140;
    private int id;
    private String author;
    private String text;
    private final String timestamp;
    private List<String> likes;

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
        if(text.length() > CHARACTERS_LIMIT) throw new ExceededCharactersLimitException();

        this.id = id;
        this.author = author;
        this.text = text;
        this.timestamp = getCurrentTimeStamp();
        this.likes = new LinkedList<String>();

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

    private String getCurrentTimeStamp() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public String getTimeStamp() {
        return this.timestamp;
    }

    public void addLike(String User) {
        if(User == null) throw new NullPointerException();
        if(this.likes.contains(User) ) throw new IllegalArgumentException("Non puoi mettere like due volte");
        if(User.equals(this.author)) throw new IllegalArgumentException("Non puoi mettere like al tuo post");

        this.likes.add(User);

    }

    public List<String> getLikes() {
        return this.likes;
    }

    public String toString(){

        return ("\nPost id : " + this.id + "\nUser: " + this.author + "\nPost Text: " + this.text + "\nDate published: " + this.timestamp
                    + "\nPost Likes: " + this.likes.size() + "\nPeople who liked the post :" + this.likes.toString());
    }
}



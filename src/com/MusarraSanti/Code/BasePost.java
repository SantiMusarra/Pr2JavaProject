package com.MusarraSanti.Code;

import java.util.List;

public interface BasePost {

    //OVERVIEW: Questa interfaccia definisce il tipo di dato  Post con un id , un testo , un autore
    //          una data di pubblicazione e una lista di like

    //TYPICAL ELEMENT: < id , author , text , timestamp , {likes_0,...,likes_n} >

    //EFFECTS: Return the id of this post
    public int getID();

    //EFFECTS: Return the Author of this post
    public String getAuthor();

    //EFFECTS: Return the text of this post
    public String getText();

    //EFFECTS: Return the time and date of this post
    public String getTimeStamp();

    //REQUIRES: user != null
    //THROWS: if user == null throw NullPointerException(unchecked)
    //        if user already liked the post throw IllegalArgumentException
    //MODIFIES: this
    //EFFECTS: Add a like from user for this post
    public void addLike(String User);

    //EFFECTS: Return the list of users who liked the post
    public List<String> getLikes();

    //EFFECTS: Return a string representation of this
    public String toString();

}

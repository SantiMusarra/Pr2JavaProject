package com.MusarraSanti.Code;

import java.util.HashSet;
import java.util.List;

public interface BasePost {

    //OVERVIEW:

    //TYPICAL ELEMENT:

    //Abstraction function:

    //Invariant representation:

    //EFFECTS: Return the id of this post
    public int getID();

    //EFFECTS: Return the Author of this post
    public String getAuthor();

    //EFFECTS: Return the text of this post
    public String getText();

    //MODIFIES: this
    //EFFECTS: Assign a time and date to this post
    public String setTimeStamp();

    //EFFECTS: Return the time and date of this post
    public String getTimeStamp();

    //REQUIRES: user != null
    //THROWS: if user == null throw NullPointerException(unchecked)
    //MODIFIES: this
    //EFFECTS: Add a like from user for this post
    public void addLike(String User);

    //EFFECTS: Return the list of users who liked the post
    public List getLikes();

    //EFFECTS: Return a string representation of this
    public String toString();

}

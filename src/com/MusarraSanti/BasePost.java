package com.MusarraSanti;

import java.util.List;

public interface BasePost {

    //OVERVIEW:

    //TYPICAL ELEMENT

    //Abstraction function

    //Invariant representation

    //REQUIRES: id != null
    //THROWS: if id == null throws NullPointerException(unchecked)
    //MODIFIES: this
    //EFFECTS: Assign an id to this post
    public void setID(int id);


    //EFFECTS: Return the id of this post
    public int getID();

    //REQUIRES: Author  != null
    //THROWS: if Author == null throws NullPointerException(unchecked)
    //MODIFIES: this
    //EFFECTS: Assign an Author to this post
    public void setAuthor(String Author);

    //THROWS: if Author == null throws AuthorNotFound(checked) *Opzionale*
    //EFFECTS: Return the Author of this post
    public String getAuthor();

    //REQUIRES: text != null && #text < 140
    //THROWS: if #text > 140 throws ExceedCharactersLimit(checked)
    //        if text == null throw NullPointerException(unchecked)
    //MODIFIES: this
    //EFFECTS: Assign a text of 140 characters to this post
    public void setText(String text);

    //EFFECTS: Return the text of this post
    public String getText();

    //REQUIRES: timeStamp != null
    //THROWS: if timeStamp == null throw NullPointerException(unchecked)
    //MODIFIES: this
    //EFFECTS: Assign a time and date to this post
    public void setTimeStamp(String timeStamp);

    //EFFECTS: Return the time and date of this post
    public String getTimeStamp();

    //REQUIRES: user != null
    //THROWS: if user == null throw NullPointerException(unchecked)
    //MODIFIES: this
    //EFFECTS: Add a like from user for this post
    public void setLike(String User);

    //EFFECTS: Return the list of users who liked the post
    public List getLikes();

    //EFFECTS: Return a string representation of this
    public String toString();

    //EFFECTS: Compare this with the object passed. Return true if the object are the same , false otherwise
    public boolean equals(Object other);
}

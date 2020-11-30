package com.MusarraSanti.Code;

import com.MusarraSanti.Exception.ExceededCharactersLimitException;
import com.MusarraSanti.Exception.UserNotExistException;

import java.util.LinkedList;
import java.util.List;

public class SocialNetworkOffensiveContent extends SocialNetwork {

    //OVERVIEW:
    //TYPICAL ELEMENT: <Name , list_of_offensiveWords{x,...,xn}>
    //TODO Abstraction function:

    //TODO Invariant representation:

    private List<String> offensiveWords;
    private List<Post> listOfExplicitPosts;
    private List<Post> listOfNotExplicitPosts;

    /*
    REQUIRES: nameNetwork != null && offensiveWords != null
    THROWS: if nameNetwork == null throws NullPointerException   (unchecked)
            if offensiveWords == null throws NullPointerException (unchecked)
    MODIFIES: this
    EFFECTS: Initialize this < nameNetwork >
    */
    public SocialNetworkOffensiveContent(String nameNetwork , List<String> offensiveWords) {
        super(nameNetwork);

        if(offensiveWords == null) throw new NullPointerException();
        this.offensiveWords = offensiveWords;
        this.listOfExplicitPosts = new LinkedList<>();
        this.listOfNotExplicitPosts = new LinkedList<>();
    }

    /*
       EFFECTS: restituisce quei post del social network segnalati come non offensivi
    */
    public List<Post> getNotExplicitPosts() {
        return listOfNotExplicitPosts;
    }

    /*
       EFFECTS: restituisce quei post del social network segnalati come offensivi
    */
    public List<Post> getExplicitPosts(){
        return this.listOfExplicitPosts;
    }

    /*
    REQUIRES: user != null && text != null && text.length < 140 && isUserExist(username)
    THROWS: if user == null throws NullPointerException( unchecked)
            if text == null throws NullPointerException( unchecked)
            if text.length >=140 throws ExceededCharactersLimitException ( checked )
            if !isUserExist(username) throws UserNotExistException (checked)
    MODIFIES: this
    EFFECTS: crea un post nella rete sociale e decide se metterlo nella lista dei post offensivi o nella lista dei post non offensivi
     */
    @Override
    public Post createPost(String user, String text) throws UserNotExistException, ExceededCharactersLimitException {

        Post post = super.createPost(user, text);

        if(isExplicit(post)) this.listOfExplicitPosts.add(post);
        else this.listOfNotExplicitPosts.add(post);
        return post;

    }

    /*
    REQUIRES: user != null && isUserExist(user)
    THROWS: if user == null throws NullPointerException (unchecked)
            if !isUserExist(user) throws UserNotExistException (checked)
    EFFECTS: ritorna la lista dei post offensivi dell'utente parametro
     */
    public List<Post> getUserExplicitPost(String user) throws UserNotExistException {

        if(user == null) throw new NullPointerException();
        if(!super.isUserExist(user)) throw new UserNotExistException();

        List<Post> listOfPost = new LinkedList<>();
        for (Post post : listOfExplicitPosts) {

            if(post.getAuthor().equals(user)) listOfPost.add(post);
        }

        return  listOfPost;
    }

    /*
   REQUIRES: user != null && isUserExist(user)
   THROWS: if user == null throws NullPointerException (unchecked)
           if !isUserExist(user) throws UserNotExistException (checked)
   EFFECTS: ritorna la lista dei post non offensivi dell'utente parametro
    */
    public List<Post> getUserNotExplicitPost(String user) throws UserNotExistException {

        if(user == null) throw new NullPointerException();
        if(!super.isUserExist(user)) throw new UserNotExistException();
        List<Post> listOfPost = new LinkedList<>();
        for (Post post : listOfNotExplicitPosts) {

            if(post.getAuthor().equals(user)) listOfPost.add(post);
        }

        return  listOfPost;
    }

    /*
    EFFECTS: ritorna un valore booleano : true se il post è offensivo false altrimenti
     */
    private boolean isExplicit(Post post){

        for (String word: offensiveWords) {

            if(post.getText().contains(word)) return true;
        }
        return false;
    }
}

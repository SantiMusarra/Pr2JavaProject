package com.MusarraSanti.Code;

import com.MusarraSanti.Exception.ExceededCharactersLimitException;
import com.MusarraSanti.Exception.UserAlreadyExistException;
import com.MusarraSanti.Exception.UserNotExistException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BaseSocialNetwork {

    //TODO OVERVIEW:

    //TODO TYPICAL ELEMENT:

    /*
    REQUIRES: username != null && !isUserExist(username)
    THROWS: if username == null throws NullPointerException( unchecked)
            if isUserExist(username) throws UserAlreadyExistException (checked)
    MODIFIES:this
    EFFECTS: crea un nuovo utente nella rete sociale
     */
    public void createUser(String username) throws UserAlreadyExistException;

    /*
    REQUIRES: user != null && text != null && text.length < 140 && isUserExist(username)
    THROWS: if user == null throws NullPointerException( unchecked)
            if text == null throws NullPointerException( unchecked)
            if text.length >=140 throws ExceededCharactersLimitException ( checked )
            if !isUserExist(username) throws UserNotExistException (checked)
    MODIFIES: this
    EFFECTS: crea un post nella rete sociale
     */
    public Post createPost(String user , String text)throws UserNotExistException, ExceededCharactersLimitException;


    /*
    REQUIRES: post != null && user != null  && isUserExist(user) && isUserExist(post.getAuthor())
    THROWS: if post == null throws NullPointerException( unchecked)
            if user == null throws NullPointerException( unchecked)
            if !isUserExist(user) || !isUserExist(post.getAuthor()) throw UserNotExistException( checked)
    EFFECTS: aggiunge un like ad un post nella rete sociale
     */
    public void addLikeToPost(Post post , String user) throws UserNotExistException;

    /*
    REQUIRES: ps != null
    THROWS: if ps == null throws NullPointerException( unchecked)
    EFFECTS: restituisce la rete sociale derivata dalla lista dei post (Utenti -> Follower)
     */
    public Map< String , Set<String> > guessFollowers(List<Post> ps);

    /*
    REQUIRES:  followers != null
    THROWS: if followers == null throws NullPointerException( unchecked)
    EFFECTS: restituisce i 3 utenti più influenti ( quelli con il maggior numero di followers) della rete sociale
     */
    public List<String> influencers(Map < String , Set<String> > followers);

    /*
    EFFECTS: restituisce la lista degli utenti che hanno pubblicato almeno un post nella rete sociale
     */
    public Set<String> getMentionedUsers();

    /*
    REQUIRES:  ps != null
    THROWS: if ps == null throws NullPointerException( unchecked)
    EFFECTS: restituisce dalla lista dei post una lista degli autori di quei post
     */
    public Set<String> getMentionedUsers(List<Post> ps);

    /*
    REQUIRES:   user != null && isUserExist(user)
    THROWS: if user == null throws NullPointerException ( unchecked)
            if !isUserExist(user) throws UserNotExistException( checked)
    EFFECTS:  restituisce la lista dei post pubblicati da user
     */
    public List<Post> writtenBy(String user) throws UserNotExistException;

    /*
    REQUIRES:  ps != null && user != null
    THROWS: if ps == null throws NullPointerException( unchecked)
            if user == null throws NullPointerException( unchecked)
    EFFECTS: restituisce la lista dei post pubblicati dall'utente dalla lista dei post parametro
     */
    public List<Post> writtenBy(List<Post> ps , String user);

    /*
    REQUIRES: words != null
    THROWS: words == null throws NullPointerException ( unchecked)
    EFFECTS: restituisce una lista di post che contengono le parole contenute nella lista parametro
     */
    public List<Post> containing(List<String> words);


}

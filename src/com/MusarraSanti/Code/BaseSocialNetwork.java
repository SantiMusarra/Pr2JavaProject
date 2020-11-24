package com.MusarraSanti.Code;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BaseSocialNetwork {

    //OVERVIEW:

    //TYPICAL ELEMENT:

    //Abstraction function:

    //Invariant representation:


    /*
    REQUIRES: user != null && text != null
    THROWS: if user == null throws NullPointerException
            if text == null throws NullPointerException
    MODIFIES:
    EFFETCS: crea un post nella rete sociale
     */
    public Post createPost(String user , String text);

    /*
    REQUIRES: username != null
    THROWS: if username == null throws NullPointerException
    MODIFIES:
    EFFETCS: crea un nuovo utente nella rete sociale
     */
    public void createUser(String username);

    /*
    REQUIRES: post != null && user != null
    THROWS: if post == null throws IllegalArgumentException
            if user == null throws NullPointerException
    MODIFIES:
    EFFETCS: aggiunge un like ad un post nella rete sociale
     */
    public void addLikeToPost(Post post , String user);

    /*
    REQUIRES: ps != null
    THROWS: if ps == null throws IllegalArgumentException
    MODIFIES:
    EFFETCS: restituisce la rete sociale derivata dalla lista dei post (Utenti -> Follower)
     */
    public Map< String , Set<String> > guessFollowers(List<Post> ps);

    /*
    REQUIRES:  followers != null
    THROWS: if followers == null throws NullPointerException
    MODIFIES:
    EFFETCS: restituisce i 3 utenti più influenti ( quelli con il maggior numero di followers) della rete sociale
     */
    public List<String> influencers(Map < String , Set<String> > followers);

    /*
    REQUIRES:
    THROWS:
    MODIFIES:
    EFFETCS: restituisce la lista degli utenti che hanno pubblicato almeno un post nella rete sociale
     */
    public Set<String> getMentionedUsers();

    /*
    REQUIRES:  ps != null
    THROWS: if ps == null throws NullPointerException
    MODIFIES:
    EFFETCS: restituisce dalla lista dei post una lista degli autori di quei post
     */
    public Set<String> getMentionedUsers(List<Post> ps);

    /*
    REQUIRES:   user != null
    THROWS: if user == null throws NullPointerException
    MODIFIES:
    EFFETCS:  restituisce la lista dei post pubblicati da user
     */
    public List<Post> writtenBy(String user);

    /*
    REQUIRES:   ps != null && user != null
    THROWS: if ps == null throws NullPointerException
            if user == null throws NullPointerException
    MODIFIES:
    EFFETCS: restituisce la lista dei post pubblicati dall'utente dalla lista dei post parametro
     */
    public List<Post> writtenBy(List<Post> ps , String user);

    /*
    REQUIRES: words != null
    THROWS: words == null throws NullPointerException
    MODIFIES:
    EFFETCS: restituisce una lista di post che contengono le parole contenute nella lista parametro
     */
    public List<Post> containing(List<String> words);

    /*
    REQUIRES: offensiveWords != null
    THROWS: offensiveWords == null throws NullPointerException
    MODIFIES:
    EFFETCS: restituisce una lista di post che contengono le parole contenute nella lista parametro
     */
    public List<Post> checkOffensiveContent(List<String> offensiveWords);



}

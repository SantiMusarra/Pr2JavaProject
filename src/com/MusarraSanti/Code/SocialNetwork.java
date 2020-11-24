package com.MusarraSanti.Code;

import com.MusarraSanti.Exception.ExceededCharactersLimitException;
import com.MusarraSanti.Exception.UserAlreadyExistException;
import com.MusarraSanti.Exception.UserNotExistException;

import javax.print.attribute.standard.NumberUp;
import java.util.*;


public class SocialNetwork implements BaseSocialNetwork {

    private String nameNetwork;
    private int id = 0;

    //private Map<String , User>
    //private Map<User , Void> Users; //

    private Map<String,List<Post>> userPosts; //Username -> List of Posts
    private Map<String,Set<String>> followers; //Username -> List of Followers
    private Map<String,Set<String>> followed; //Username -> List of Followed

    /*
    REQUIRES: nameNetwork != null
    THROWS: if nameNetwork == null throws NullPointerException   (unchecked)
    MODIFIES: this
    EFFECTS: Initialize this < nameNetwork >
    */
    public SocialNetwork(String nameNetwork){
        if(nameNetwork == null) throw new NullPointerException();

        this.nameNetwork = nameNetwork;
        this.userPosts = new HashMap<String, List<Post>>();
        this.followers = new HashMap<String, Set<String>>();
        this.followed = new HashMap<String,Set<String>>();
    }

    private boolean isUserExist(String user){
        //TODO SCRIVERE SPECIFICA
        if(user == null) throw new NullPointerException();

        return userPosts.containsKey(user);
    }

    public void createUser(String username) throws UserAlreadyExistException {
        if(username == null ) throw new NullPointerException();

        //Verifico che l'utene non sia già presente all'interno della rete sociale
        if(isUserExist(username)) throw new UserAlreadyExistException();

        List<Post> listOfPost = new LinkedList<Post>();
        Set<String> listOfFollowers = new HashSet<String>();
        Set<String> listOfFollowed = new HashSet<String>();

        //Creo una Map user -> post che rappresenta tutti i post dell'utente attualmente inizializzata
        this.userPosts.put(username, listOfPost);
        //Creo una Map user -> string che rappresenta tutti i followers dell'utente attualmente inizializzata
        this.followers.put(username,listOfFollowers);
        //Creo una Map user -> string che rappresenta tutti gli utenti seguiti dall'utente attualmente inizializzata
        this.followed.put(username, listOfFollowed);

    }

    public Post createPost(String user , String text) throws UserNotExistException ,ExceededCharactersLimitException {

        if(user == null || text == null) throw new NullPointerException();
        //Controllo che il testo non sia più di 140 caratteri
        if(text.length() > Post.CHARACTERS_LIMIT ) throw new ExceededCharactersLimitException();
        //Controllo che user sia all'interno della rete sociale
        if(!isUserExist(user)) throw new UserNotExistException();

        //Creo il post e lo inserisco nella lista dei post dell'utente
        Post myPost = new Post(id , user , text);
        id++;
        List<Post> listOfPosts = userPosts.get(user);
        listOfPosts.add(myPost);
        return myPost;

    }

    public void addLikeToPost(Post post , String user) throws  UserNotExistException{

        if(post == null) throw new NullPointerException();
        if(user == null) throw new NullPointerException();

        //Controllo che l'utente e l'autore del post esistano
        if(!isUserExist(user) || !isUserExist(post.getAuthor()) ) throw new UserNotExistException();

        //Aggiungo l'utente alla lista dei like del post
        post.addLike(user);

        //Aggiungo username ai followers dell'autore del post
        Set<String> listOfFollowers = followers.get(post.getAuthor());
        listOfFollowers.add(user);

        //Aggiungo l'autore del post ai followed ( I seguiti ) di username
        Set<String> listOfFollowed = followed.get(user);
        listOfFollowed.add(post.getAuthor());

    }

    public Map<String, Set<String>> guessFollowers(List<Post> ps) {

        if(ps == null) throw new NullPointerException();

        Map<String , Set<String>> guessedFollowers = new HashMap<>();

        for (Post post : ps) {
            Set<String> followers;

            if(!guessedFollowers.containsKey(post.getAuthor())){
                followers =  new HashSet<String>();
                guessedFollowers.put(post.getAuthor() , followers);
            }
            else{
                followers = guessedFollowers.get(post.getAuthor());
            }
            followers.addAll(post.getLikes());

        }
        return guessedFollowers;
    }

    public List<String> influencers(Map<String, Set<String>> followers) {

        String firstUser;
        int firstUserFollowers = -1;
        String secondUser;
        int secondUserFollowers = -1;
        String thirdUser;
        int thirdUserFollowers = -1;

        for (Map.Entry<String, Set<String>> entry: followers.entrySet()) {

            String user = entry.getKey();
            Set<String> userFollowers = entry.getValue();

            int countedFollowers = userFollowers.size();

            if(countedFollowers > firstUserFollowers){      //BESTEMMIARE A DOMENICO
                firstUser = user;
                firstUserFollowers = countedFollowers;
            }
            else if(countedFollowers == firstUserFollowers){
            //IL SECONDO DEVE DIVENTARE IL TERZO

                // Counted deve diventare il secondo

            }
        }

        return null;
    }

    public Set<String> getMentionedUsers() {
        return null;
    }

    public Set<String> getMentionedUsers(List<Post> ps) {
        return null;
    }

    public List<Post> writtenBy(String user) throws UserNotExistException{

        if(user == null) throw new NullPointerException();
        if(!isUserExist(user)) throw new UserNotExistException();

        List<Post> postList = userPosts.get(user);
        return postList;
    }

    public List<Post> writtenBy(List<Post> ps, String user){

        if(user == null) throw new NullPointerException();
        if(ps == null) throw   new NullPointerException();

        List<Post> listOfPost = new LinkedList<>();

        for (Post post : ps) {

            if(post.getAuthor().equals(user)) listOfPost.add(post);

        }

        return listOfPost;
    }

    public List<Post> containing(List<String> words) {
        return null;
    }

    public List<Post> checkOffensiveContent(List<String> offensiveWords) {
        return null;
    }
}

package com.MusarraSanti.Code;

import com.MusarraSanti.Exception.ExceededCharactersLimitException;
import com.MusarraSanti.Exception.UserAlreadyExistException;
import com.MusarraSanti.Exception.UserNotExistException;
import java.util.*;


public class SocialNetwork implements BaseSocialNetwork {

    //OVERVIEW: Questa interfaccia definisce il tipo di dato SocialNetwork assegnandoli un nome

    //TODO Abstraction function:

    //TODO Invariant representation:    nameNetwork != null && user != null && posts{x1,...,xn} != null
    //                                  && text.length < CHARACTERS_LIMIT && Map<String , Set<String> != null
    //                                  && post != null && words{x1,...,xn} != null


    private String nameNetwork;
    private int id = 0;

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

    /*
    REQUIRES: user != null
    THROWS: if user == null throws NullPointerException
    EFFECTS: ritorna la verifica dell'esistenza dell'utente. True se l'utente esiste false altrimenti
    */
    public boolean isUserExist(String user){

        if(user == null) throw new NullPointerException();

        return userPosts.containsKey(user);
    }

    public void createUser(String username) throws UserAlreadyExistException {
        if(username == null ) throw new NullPointerException();

        //Verifico che l'utene non sia già presente all'interno della rete sociale
        if(isUserExist(username)) throw new UserAlreadyExistException();

        List<Post> listOfPost = new LinkedList<>();
        Set<String> listOfFollowers = new HashSet<>();
        Set<String> listOfFollowed = new HashSet<>();

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

    //Ritorna una Mappa che associa Utente a numero di followers in base alla lista dei post passata come parametro
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
    //Ritorna i primi 3 utenti con più followers dalla Map followers passata come parametro
    public List<String> influencers(Map<String, Set<String>> followers) {

        if(followers == null)   throw new NullPointerException();

        List<String> influencer = new LinkedList<>();
        List<Integer> numberOfFollowers = new LinkedList<>();

        for (Map.Entry<String, Set<String>> entry: followers.entrySet()) {

            String user = entry.getKey();
            Set<String> userFollowers = entry.getValue();

            int countedFollowers = userFollowers.size();
            int i = 0;
            while(i < numberOfFollowers.size() && countedFollowers < numberOfFollowers.get(i) ){
                i++;
            }
            influencer.add(i, user);
            numberOfFollowers.add(i ,countedFollowers);

        }

        return influencer.subList(0,Math.min(3,influencer.size()));
    }

    //Ritorna la lista degli utenti del social network che sono iscritti
    public Set<String> getMentionedUsers() {

        Set<String> listOfUsers = new HashSet<>();

        for (Map.Entry<String ,List<Post>> entry : userPosts.entrySet()) {

            listOfUsers.add(entry.getKey());
        }
        return listOfUsers;
    }

    //Ritorna la lista degli utenti che hanno scritto almeno un post tra quelli passati o //optional:che hanno messo like ad almeno uno dei post passati
    public Set<String> getMentionedUsers(List<Post> ps) {

        if(ps == null) throw new NullPointerException();

        Set<String> listOfUsers = new HashSet<>();

        for (Post post : ps) {

            listOfUsers.add(post.getAuthor());
            //listOfUsers.addAll(post.getLikes());
        }

        return listOfUsers;
    }
    //Ritorna la lista dei post scritti da "user"
    public List<Post> writtenBy(String user) throws UserNotExistException{

        if(user == null) throw new NullPointerException();
        if(!isUserExist(user)) throw new UserNotExistException();

        List<Post> postList = userPosts.get(user);
        return postList;
    }
    //Ritorna la lista dei post scritti da user dalla lista dei post ricevuta come parametro
    public List<Post> writtenBy(List<Post> ps, String user){

        if(user == null) throw new NullPointerException();
        if(ps == null) throw   new NullPointerException();

        List<Post> listOfPost = new LinkedList<>();

        for (Post post : ps) {

            if(post.getAuthor().equals(user)) listOfPost.add(post);

        }

        return listOfPost;
    }
    //Ritorna la lista dei post che contiene almeno una parola contenuta nella lista parametro
    public List<Post> containing(List<String> words) {

        if(words == null) throw new NullPointerException();

        List<Post> posts = new LinkedList<>();

        for (Map.Entry<String , List<Post>> entry : userPosts.entrySet()) {

            for (Post post : entry.getValue()) {

                for (String word: words) {

                    if(post.getText().contains(word)){

                        posts.add(post);
                        break;
                    }

                }

            }

        }
        return posts;
    }

}

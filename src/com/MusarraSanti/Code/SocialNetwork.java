package com.MusarraSanti.Code;

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

    public Post createPost(String user , String text){

        if(user == null || text == null) throw new NullPointerException();

        //Controllo che user sia all'interno della rete sociale
        if(userPosts.containsKey(user)) {
            //Creo il post controllando che la sua creazione  superi i controlli e lo inserisco nella lista dei post dell'utente
            try{
                Post myPost = new Post(id++ , user , text);
                List<Post> listOfPosts = userPosts.get(user);
                listOfPosts.add(myPost);
                System.out.println("Post Created Successfully with" + myPost.toString() + "\n");
                return myPost;

            }
            catch(Exception e){  //Gestisco le eccezioni ExceededCharactersLimitException e IllegalArgumentException
                System.out.println(e.getMessage());
                return null;
            }
        }
        else return null;

    }

    public void createUser(String username){
        if(username == null ) throw new NullPointerException();

        //Verifico che l'utene non sia già presente all'interno della rete sociale
        if(userPosts.containsKey(username)) System.out.println("Utente " + username +" già presente nella Rete Sociale");
        else{
            List<Post> listOfPost = new LinkedList<>();
            Set<String> listOfFollowers = new HashSet<String>();
            Set<String> listOfFollowed = new HashSet<String>();

            //Creo una Map user -> post che rappresenta tutti i post dell'utente attualmente inizializzata
            this.userPosts.put(username, listOfPost);
            //Creo una Map user -> string che rappresenta tutti i followers dell'utente attualmente inizializzata
            this.followers.put(username,listOfFollowers);
            //Creo una Map user -> string che rappresenta tutti gli utenti seguiti dall'utente attualmente inizializzata
            this.followed.put(username, listOfFollowed);
        }
    }

    public void addLikeToPost(Post post , String user){

        if(post == null) throw new IllegalArgumentException();
        if(user == null) throw new NullPointerException();

        //Controllo che l'utente esista
        if(userPosts.containsKey(user)){

            //Aggiungo l'utente alla lista dei like del post
            post.addLike(user);

            //Aggiungo username ai followers dell'autore del post
            Set<String> listOfFollowers = followers.get(post.getAuthor());
            listOfFollowers.add(user);

            //Aggiungo l'autore del post ai followed ( I seguiti ) di username
            Set<String> listOfFollowed = followed.get(user);
            listOfFollowed.add(post.getAuthor());
        }
        else System.out.println("Utente " + user + " non presente nella rete sociale e non può mettere like");

    }

    public Map<String, Set<String>> guessFollowers(List<Post> ps) {

        if(ps == null) throw new NullPointerException();
        for (Post post : ps) {
            post.getAuthor();
        }
        //OTTENERE GLI USERNAME DALLA LISTA DEI POST E TORNARE LA MAPPA DEI RELATIVI USER


        return null;
    }

    public List<String> influencers(Map<String, Set<String>> followers) {
        return null;
    }

    public Set<String> getMentionedUsers() {
        return null;
    }

    public Set<String> getMentionedUsers(List<Post> ps) {
        return null;
    }

    public List<Post> writtenBy(String user) {

        //VERIFICA CHE L'UTENTE ABBIA SCRITTO ALMENO UNA VOLTA UN POST ALTRIMENTI STAMPARE UN AVVISO
        if(userPosts.get(user).isEmpty()) System.out.println("\nL'utente " + user + " non ha ancora scritto nessun post");
        else {
            System.out.println("Posts written by user named " + user);
            List<Post> postList = userPosts.get(user);
            return postList;
        }
        return null;
    }

    public List<Post> writtenBy(List<Post> ps, String user) {
        return null;
    }

    public List<Post> containing(List<String> words) {
        return null;
    }

    public List<Post> checkOffensiveContent(List<String> offensiveWords) {
        return null;
    }
}

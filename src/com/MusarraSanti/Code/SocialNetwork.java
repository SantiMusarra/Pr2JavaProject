package com.MusarraSanti.Code;

import java.util.*;


public class SocialNetwork implements BaseSocialNetwork {

    private String nameNetwork;
    private int id = 0;
    //private Map<String , User>
    //private Map<User , Void> Users; //
    private Map<String,List<Post>> userPosts; //Username -> List of Posts
    private Map<String,Set<String>> followers; //Username -> List of Followers
    private Map<String,Set<String>> followed; //Username -> List of Followed


    public SocialNetwork(String nameNetwork){

        this.nameNetwork = nameNetwork;
        this.userPosts = new HashMap<String, List<Post>>();
        this.followers = new HashMap<String, Set<String>>();
        this.followed = new HashMap<String,Set<String>>();
    }

    public Post createPost(String user , String text){
        //Creo il post controllando la sua creazione e se supera i controlli lo inserisco nella lista dei post dell'utente
        try{
            Post myPost = new Post(id++ , user , text);
            List listOfPosts = userPosts.get(user);
            listOfPosts.add(myPost);
            System.out.println("Post Created Successfully with" + myPost.toString() + "\n");
            return myPost;

        }
        catch(Exception e){  //Gestisco le eccezioni ExceededCharactersLimitException e IllegalArgumentException
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void createUser(String username){

        //VERIFICARE CHE NON ESISTE GIA' L'UTENTE CHE SI STA CERCANDO DI CREARE
        List<Post> listOfPost = new LinkedList<>();
        Set listOfFollowers = new HashSet<String>();
        Set listOfFollowed = new HashSet<String>();

        this.userPosts.put(username, listOfPost);
        this.followers.put(username,listOfFollowers);
        this.followed.put(username, listOfFollowed);
    }

    public void addLikeToPost(Post post , String user){

        post.addLike(user);

        //TO DO CONTROLLARE CHE USER SIA ALL'INTERNO DEL SOCIAL NETWORK!

        //Aggiungo username ai followers dell'autore del post
        Set listOfFollowers = followers.get(post.getAuthor());
        listOfFollowers.add(user);

        //Aggiungo l'autore del post ai followed ( I seguiti ) di username
        Set listOfFollowed = followed.get(user);
        listOfFollowed.add(post.getAuthor());


    }

    public Map<String, Set<String>> guessFollowers(List<Post> ps) {

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

    public List<Post> writtenBy(String Username) {

        //VERIFICA CHE L'UTENTE ABBIA SCRITTO ALMENO UNA VOLTA UN POST ALTRIMENTI STAMPARE UN AVVISO
        System.out.println("Posts written by user named " + Username);
        List<Post> postList = userPosts.get(Username);
        return postList;
    }

    public List<Post> writtenBy(List<Post> ps, String username) {
        return null;
    }

    public List<Post> containing(List<String> words) {
        return null;
    }
}

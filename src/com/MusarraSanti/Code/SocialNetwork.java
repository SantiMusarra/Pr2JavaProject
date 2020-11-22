package com.MusarraSanti.Code;

import java.util.*;


public class SocialNetwork implements BaseSocialNetwork {

    private String nameNetwork;
    private int id = 0;
    //private Map<String , User>
    //private Map<User , Void> Users; //
    private Map<String,List<Post>> posts; //Username -> List of Posts
    private Map<String,Set<String>> followers; //Username -> List of Followers
    private Map<String,Set<String>> followed; //Username -> List of Followed


    public SocialNetwork(String nameNetwork){

        this.nameNetwork = nameNetwork;
        this.posts = new HashMap<String, List<Post>>();
        this.followers = new HashMap<String, Set<String>>();
        this.followed = new HashMap<String,Set<String>>();
    }

    public void createPost(String username , String text){

        try{
            Post myPost = new Post(id++ , username , text);
            List listOfPosts = posts.get(username);
            listOfPosts.add(myPost);
            System.out.println(myPost.toString());

        }
        catch(Exception e){  //Gestisco le eccezioni ExceededCharactersLimitException e IllegalArgumentException
            System.out.println(e.getMessage());
        }
    }

    public void createUser(String username){

        List<Post> listOfPost = new LinkedList<>();
        Set listOfFollowers = new HashSet<String>();
        Set listOfFollowed = new HashSet<String>();

        this.posts.put(username, listOfPost);
        this.followers.put(username,listOfFollowers);
        this.followed.put(username, listOfFollowed);
    }


    public Map<String, Set<String>> guessFollowers(List<Post> ps) {
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

        List<Post> postList = posts.get(Username);
        return postList;
    }

    public List<Post> writtenBy(List<Post> ps, String username) {
        return null;
    }

    public List<Post> containing(List<String> words) {
        return null;
    }
}

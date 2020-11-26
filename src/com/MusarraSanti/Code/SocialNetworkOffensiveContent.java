package com.MusarraSanti.Code;

import com.MusarraSanti.Exception.ExceededCharactersLimitException;
import com.MusarraSanti.Exception.UserNotExistException;

import java.util.LinkedList;
import java.util.List;

public class SocialNetworkOffensiveContent extends SocialNetwork {

    private List<String> offensiveWords;
    private List<Post> listOfExplicitPosts;
    private List<Post> listOfNotExplicitPosts;

    //TODO SPECIFICA
    public SocialNetworkOffensiveContent(String nameNetwork , List<String> offensiveWords) {
        super(nameNetwork);

        if(offensiveWords == null) throw new NullPointerException();
        this.offensiveWords = offensiveWords;
        this.listOfExplicitPosts = new LinkedList<>();
        this.listOfNotExplicitPosts = new LinkedList<>();
    }

    /*
       EFFECTS: restituisce quei post del social network segnalati come offensivi
    */

    public List<Post> getNotExplicitPosts() {
        return listOfNotExplicitPosts;
    }

    public List<Post> getExplicitPosts(){
        return this.listOfExplicitPosts;
    }

    @Override
    public Post createPost(String user, String text) throws UserNotExistException, ExceededCharactersLimitException {

        Post post = super.createPost(user, text);

        if(isExplicit(post)) this.listOfExplicitPosts.add(post);
        else this.listOfNotExplicitPosts.add(post);
        return post;

    }

    public List<Post> getUserExplicitPost(String user){

        if(user == null) throw new NullPointerException();

        List<Post> listOfPost = new LinkedList<>();
        for (Post post : listOfExplicitPosts) {

            if(post.getAuthor().equals(user)) listOfPost.add(post);
        }

        return  listOfPost;
    }

    public List<Post> getUserNotExplicitPost(String user){

        if(user == null) throw new NullPointerException();

        List<Post> listOfPost = new LinkedList<>();
        for (Post post : listOfNotExplicitPosts) {

            if(post.getAuthor().equals(user)) listOfPost.add(post);
        }

        return  listOfPost;
    }

    /*


     */
    private boolean isExplicit(Post post){

        for (String word: offensiveWords) {

            if(post.getText().contains(word)) return true;
        }
        return false;
    }
}

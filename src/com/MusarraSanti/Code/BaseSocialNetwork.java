package com.MusarraSanti.Code;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BaseSocialNetwork {

    //OVERVIEW:

    //TYPICAL ELEMENT:

    //Abstraction function:

    //Invariant representation:

    public Map< String , Set<String> > guessFollowers(List<Post> ps);

    public List<String> influencers(Map < String , Set<String> > followers);

    public Set<String> getMentionedUsers();

    public Set<String> getMentionedUsers(List<Post> ps);

    public List<Post> writtenBy(String Username);

    public List<Post> writtenBy(List<Post> ps , String username);

    public List<Post> containing(List<String> words);



}

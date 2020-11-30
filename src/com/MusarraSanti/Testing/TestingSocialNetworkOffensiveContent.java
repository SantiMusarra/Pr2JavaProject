package com.MusarraSanti.Testing;

import com.MusarraSanti.Code.Post;
import com.MusarraSanti.Code.SocialNetwork;
import com.MusarraSanti.Code.SocialNetworkOffensiveContent;
import com.MusarraSanti.Exception.ExceededCharactersLimitException;
import com.MusarraSanti.Exception.UserAlreadyExistException;
import com.MusarraSanti.Exception.UserNotExistException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestingSocialNetworkOffensiveContent {

    //Lista parole offensive
    private static List<String> offensiveWords = Arrays.asList("maremma" ,"stronzo" , "stupido" , "merda" , "coglione");

    //Social Network
    private static SocialNetworkOffensiveContent MicroBlog = new SocialNetworkOffensiveContent("MicroBlog",offensiveWords);

    //Utenti
    private static String utente1 = "Santi";
    private static String utente2 = "Giacomo";
    private static String utente3 = "Luca";
    private static String utente4 = "Domenico";
    private static String utente5 = "Matteo";



    public static void RunTestCreateOffensivePost(){

        try {
            MicroBlog.createUser(utente1);
            MicroBlog.createUser(utente2);
            MicroBlog.createUser(utente3);
            MicroBlog.createUser(utente4);
            MicroBlog.createUser(utente5);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
             MicroBlog.createPost(utente1,"sei una merda");
             MicroBlog.createPost(utente2,"Poker face");
             MicroBlog.createPost(utente4,"Saro Falsapepe è proprio stupido");
             MicroBlog.createPost(utente1,"La vita è bella");
             MicroBlog.createPost(utente2,"Blu dipinto di blu");
             MicroBlog.createPost(utente4,"Oggi c'è un cielo stupendo");
             MicroBlog.createPost(utente3,"Oggi c'è un tempo di merda");
             MicroBlog.createPost(utente3,"Il sole splende come non ha mai....");
             MicroBlog.createPost(utente2,"Post malone");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public static void RunTestGetExplicitPosts(){
        System.out.println("--------------------------------LISTA DI TUTTI I POST OFFENSIVI------------------");
        System.out.println(MicroBlog.getExplicitPosts());
    }

    public static void RunTestGetNotExplicitPosts(){
        System.out.println("--------------------------------LISTA DI TUTTI I POST NON OFFENSIVI------------------");
        System.out.println(MicroBlog.getNotExplicitPosts());
    }


    public static void RunTestGetUserExplicitPosts(){

        System.out.println("--------------------------------LISTA DI TUTTI I POST OFFENSIVI DA PARTE DI UN UTENTE------------------");

        System.out.println("Lista dei post offensivi dell'utente1");
        try {
            System.out.println(MicroBlog.getUserExplicitPost(utente1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Lista dei post offensivi dell'utente 4");
        try {
            System.out.println(MicroBlog.getUserExplicitPost(utente4));
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

    }
    public static void RunTestGetUserNotExplicitPosts(){

        System.out.println("--------------------------------LISTA DI TUTTI I POST NON OFFENSIVI DA PARTE DI UN UTENTE------------------");

        System.out.println("Lista dei post non offensivi dell'utente 1");
        try {
            System.out.println(MicroBlog.getUserNotExplicitPost(utente1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Lista dei post non offensivi dell'utente 2");
        try {
            System.out.println(MicroBlog.getUserNotExplicitPost(utente2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

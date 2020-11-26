package com.MusarraSanti.Testing;

import com.MusarraSanti.Code.Post;
import com.MusarraSanti.Code.SocialNetwork;

import java.util.*;

public class TestingSocialNetwork {

    //Social Network
    private static SocialNetwork MicroBlog = new SocialNetwork("MicroBlog");

    //Utenti
    private static String utente1 = "Santi";
    private static String utente2 = "Giacomo";
    private static String utente3 = "Luca";
    private static String utente4 = "Domenico";
    private static String utente5 = "Matteo";
    private static String utente6 = "Matteo";

    //Posts
    private static Post post1;
    private static Post post2;
    private static Post post3;
    private static Post post4;
    private static Post post5;



    public static void RunTestCreateUser(){

        System.out.println("\n---------------------TEST MicroBlog Creazione Utenti---------------------");
        try{
            System.out.println("Creo utente " + utente1);
            MicroBlog.createUser(utente1);

            System.out.println("Creo utente " + utente2);
            MicroBlog.createUser(utente2);

            System.out.println("Creo utente " + utente3);
            MicroBlog.createUser(utente3);

            System.out.println("Creo utente " + utente4);
            MicroBlog.createUser(utente4);

            System.out.println("Creo utente " + utente5);
            MicroBlog.createUser(utente5);

            System.out.println("Creo utente " + utente6);
            MicroBlog.createUser(utente6);

        }
        catch (Exception e){  //Gestisco l'eccezzione UserAlreadyExist

            System.out.println("Utente non creato: " + e.getMessage());
        }

    }

    public static void RunTestCreatePosts(){

        System.out.println("\n---------------------TEST MicroBlog Creazione Post all'interno della rete sociale---------------------");

        try{
            System.out.println("Creo Post 1");
            post1 = MicroBlog.createPost(utente1 ,"Hollywood, Hollywood, guarda che cielo blu avevo dei problemi, adesso non ce li ho più");
            System.out.println(post1.toString());

            System.out.println("\nCreo Post 2");
            post2 = MicroBlog.createPost(utente2 , "Blu dipinto di blu");
            System.out.println(post2.toString());

            System.out.println("\nCreo Post 3");
            post3 = MicroBlog.createPost(utente4 , "La formula 1 mi piace un casino");
            System.out.println(post3.toString());

            System.out.println("\nCreo Post 4");
            post5 = MicroBlog.createPost(utente4 , "Hollywood Boolevard");
            System.out.println(post5.toString());

            System.out.println("\nCreo Post 5");
            post4 = MicroBlog.createPost(utente3 , "Questo testo sarà troppo lungo per entrare in un post xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println(post4.toString());


        }
        catch (Exception e){ //Gestisco le eccezzioni UserNotExistException e ExceededCharactersLimitException
            System.out.println(e.getMessage());
        }

    }

    public static void RunTestAddLikeToPosts(){

        System.out.println("\n---------------------TEST MicroBlog Aggiunta Like ai Post della rete sociale---------------------\n");

        //Controllo i like messi correttamente
        try{
            System.out.println("Aggiungo like al post 3 da parte dell'utente 1");
            MicroBlog.addLikeToPost(post3 , utente1);

            System.out.println("Aggiungo like al post 3 da parte dell'utente 2");
            MicroBlog.addLikeToPost(post3 , utente2);

            System.out.println("Aggiungo like al post 3 da parte dell'utente 5");
            MicroBlog.addLikeToPost(post3 , utente5);

            System.out.println("Aggiungo like al post 3 da parte dell'utente 3");
            MicroBlog.addLikeToPost(post3 , utente3);

            System.out.println("Aggiungo like al post 1 da parte dell'utente 3");
            MicroBlog.addLikeToPost(post1 , utente3);

            System.out.println("Aggiungo like al post 1 da parte dell'utente 1");
            MicroBlog.addLikeToPost(post1 , utente1);

        }
        catch (Exception e){ //Gestisco le eccezzioni UserNotExistException
            System.out.println(e.getMessage());

        }

        //Test aggiunta secondo like allo stesso post
        try{

            System.out.println("Aggiungo un secondo like al post 1 da parte dell'utente 3");
            MicroBlog.addLikeToPost(post1 , utente3);
        }
        catch (Exception e){

            System.out.println(e.getMessage());

        }

    }

    public static void RunTestGuessFollowers(){

        System.out.println("\n---------------------TEST MicroBlog GuessFollowers e Influencers---------------------\n");

        List<Post> listOfPosts = new LinkedList<>();
        listOfPosts.add(post1);
        listOfPosts.add(post2);
        listOfPosts.add(post3);

        Map<String , Set<String>> followers = MicroBlog.guessFollowers(listOfPosts);

        List<String> mostFollowers =  MicroBlog.influencers(followers);

        System.out.println("Top 3 degli utenti più popolari ( in ordine crescente da sinistra verso destra ) :" + mostFollowers.toString());
    }

    public static void RunTestGetMentionedUser(){

        System.out.println("\n---------------------TEST MicroBlog GetMentionedUsers---------------------\n");

        List<Post> listOfPosts = new LinkedList<>();
        listOfPosts.add(post1);
        listOfPosts.add(post2);
        listOfPosts.add(post3);

        Set<String> listOfUsers = new HashSet<>();

        listOfUsers = MicroBlog.getMentionedUsers();
        System.out.println("Lista degli utenti iscritti alla rete sociale :" + listOfUsers.toString());

        //Test per getMentionedUsers con parametro

        listOfUsers = MicroBlog.getMentionedUsers(listOfPosts);
        System.out.println("Lista degli utenti data dalla lista dei post  :" + listOfUsers.toString());

    }

    public static void RunTestWrittenBy(){

        System.out.println("\n---------------------TEST MicroBlog WrittenBy---------------------\n");

        try{
            System.out.println("Stampo i post dell'utente 1");
            System.out.println(MicroBlog.writtenBy(utente1).toString());

            System.out.println("\nStampo i post dell'utente 4");
            System.out.println(MicroBlog.writtenBy(utente4).toString());

            System.out.println("\nStampo i post dell'utente Francesco");
            System.out.println(MicroBlog.writtenBy("Francesco").toString());
        }
        catch(Exception e ){    //Gestisco l'eccezione UserNotExistException
            System.out.println(e.getMessage());
        }

        //Testing WrittenBy con Parametri
        System.out.println("\n---------------------WrittenBy con parametro---------------------\n");
        List<Post> listOfPosts = new LinkedList<>();
        listOfPosts.add(post1);
        listOfPosts.add(post2);
        listOfPosts.add(post3);
        listOfPosts.add(post5);

        try{
            System.out.println("\nCerco i post dell'utente 4");
            System.out.println(MicroBlog.writtenBy(listOfPosts,utente4).toString());

            System.out.println("\nCerco i post di Francesco");
            System.out.println(MicroBlog.writtenBy(listOfPosts,"Francesco").toString());

        }
        catch (Exception e){    //Gestisco l'eccezione UserNotExistException
            System.out.println(e.getMessage());
        }


    }

    public static void RunTestContaining(){

        System.out.println("\n---------------------TEST MicroBlog Containing---------------------\n");

        List<String> words = new ArrayList<>();

        words.add("Hollywood");
        words.add("dipinto");
        words.add("Alabarda");
        words.add("mosaico");
        System.out.println("Lista di parole controllare :" + words.toString());
        System.out.println("Cerco e stampo i post che includono almeno una delle parole presenti nella lista ricevuta");
        System.out.println(MicroBlog.containing(words).toString());

    }

}

package com.MusarraSanti.Code;

import com.MusarraSanti.Testing.TestingSocialNetwork;
import com.MusarraSanti.Testing.TestingSocialNetworkOffensiveContent;

public class BatteriaTest {

    public static void main(String[] args) {

        System.out.println("\n---------------------INIZIO BATTERIA DI TEST---------------------\n");

        TestingSocialNetwork.RunTestCreateUser();       // Testing Creazione Utente
        TestingSocialNetwork.RunTestCreatePosts();      //Testing Creazione post all'interno della rete sociale
        TestingSocialNetwork.RunTestAddLikeToPosts();   //Testing Aggiunta like ai post
        TestingSocialNetwork.RunTestGuessFollowers();   //Testing dei metodi GuessFollowers e Influencers
        TestingSocialNetwork.RunTestGetMentionedUser(); //Testing dei metodi GetMentionedUser
        TestingSocialNetwork.RunTestWrittenBy();        //Testing dei metodi WrittenBy
        TestingSocialNetwork.RunTestContaining();       //Testing dei metodi Containing


        System.out.println("\n---------------------INIZIO BATTERIA DI TEST SOCIAL NETWORK OFFENSIVE CONTENT---------------------\n");

        TestingSocialNetworkOffensiveContent.RunTestCreateOffensivePost();
        TestingSocialNetworkOffensiveContent.RunTestGetExplicitPosts();
        TestingSocialNetworkOffensiveContent.RunTestGetNotExplicitPosts();
        TestingSocialNetworkOffensiveContent.RunTestGetUserExplicitPosts();
        TestingSocialNetworkOffensiveContent.RunTestGetUserNotExplicitPosts();


        System.out.println("\n---------------------FINE BATTERIA DI TEST---------------------\n");
    }
}

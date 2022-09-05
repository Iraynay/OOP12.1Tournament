package ru.netology;

import java.util.Arrays;
import java.util.Collection;

public class Main {

    public static void main(String[] Args) {

        Repo repository = new Repo();

        Player player1 = new Player(01, "Anna", 5);
        Player player2 = new Player(02, "Boris", 3);
        Player player3 = new Player(03, "Ira", 7);
        Player player4 = new Player(04, "Roma", 2);
        Player player5 = new Player(05, "Lena", 4);
        Player player6 = new Player(06, "Kate", 3);

        Game game = new Game(repository);



        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        Player[] result1 = game.getAll();
        System.out.println("All players: " + Arrays.toString(result1));
//        Player result2 = game.findPlayer1ByName("Boris");
//        System.out.println("Player1: " + result2);
//
//        Player result3 = game.findPlayer2ByName("Ira");
//        System.out.println("Player2: " + result3);

        int result4 = game.round("Anna", "Boris");
        System.out.println("RoundResult: " + result4);

    }
}

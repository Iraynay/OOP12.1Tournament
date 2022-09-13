package ru.netology;

import java.util.ArrayList;
import java.util.Collection;

import ru.netology.exception.NotRegisteredException;

public class Game {

    private Collection<Player> players = new ArrayList<>();
    private Player playerOne;
    private Player playerTwo;


    public void register(Player player) {
        players.add(player);
    }

    public Collection<Player> findAll() {
        return players;
    }

    public Player[] getAll() {
        Collection<Player> result = findAll();
        return result.toArray(new Player[0]);
    }


    public Boolean matches(Player player, String query) {
        if (player.getName().equals(query)) {
            return true;
        } else {
            return false;
        }
    }

    public Player[] findPlayersByName(String name1, String name2) {
        for (Player player : findAll()) {
            if (matches(player, name1)) {
                playerOne = player;
            }
            if (matches(player, name2)) {
                playerTwo = player;
            }
        }
        if (playerOne == null) {
            throw new NotRegisteredException("Игрок " + name1 + " не найден");
        }
        if (playerTwo == null) {
            throw new NotRegisteredException("Игрок " + name2 + " не найден");
        }
        Player[] playersByName = new Player[2];
        playersByName[0] = playerOne;
        playersByName[1] = playerTwo;

        return playersByName;

    }


    public int round(String playerName1, String playerName2) {
        findPlayersByName(playerName1, playerName2);
        Player player1 = playerOne;
        Player player2 = playerTwo;

        int roundResult = player1.compareTo(player2);
        return roundResult;


    }
}

//    public Player findPlayer1ByName(String name) {
//        for (Player player : repository.findAll()) {
//            if (matches(player, name)) {
//                playerOne = player;
//            }
//        }
//            if (playerOne == null) {
//                throw new NotRegisteredException("Игрок " + name + " не найден");
//            }
//
//            return playerOne;
//
//    }
//
//    public Player findPlayer2ByName(String name) {
//        for (Player player2 : repository.findAll()) {
//            if (matches(player2, name)) {
//                playerTwo = player2;
//            }
//        }
//            if (playerTwo == null) {
//                throw new NotRegisteredException("Игрок " + name + " не найден");
//            }
//
//
//        return playerTwo;
//    }

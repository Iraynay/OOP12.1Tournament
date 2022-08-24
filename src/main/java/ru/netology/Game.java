package ru.netology;

import java.util.Collection;

import ru.netology.exception.NotRegisteredException;

public class Game {

    private Collection<Player> players;
    Repo repository;
    private Player Player1;
    private Player Player2;


    public Game(Repo repository) {
        this.repository = repository;
    }

    public void register(Player player) {
        repository.add(player);

    }

    public Player[] getAll() {
        return repository.findAll().toArray(new Player[0]);
    }

    public Boolean matches(Player player, String query) {
        if (player.getName().equals(query)) {
            return true;
        } else {
            return false;
        }
    }

    public Player findPlayer1ByName(String name) {
        for (Player player : repository.findAll())
            if (matches(player, name)) {
                Player1 = player;
            }
        if (Player1 == null) {
            throw new NotRegisteredException("Игрок " + name + " не найден");

        }
        return Player1;
    }

    public Player findPlayer2ByName(String name) {
        for (Player player2 : repository.findAll())
            if (matches(player2, name)) {
                Player2 = player2;
            }
        if (Player2 == null) {
            throw new NotRegisteredException("Игрок " + name + " не найден");
        }
        return Player2;
    }


    public int round(String playerName1, String playerName2) {

        Player player1 = findPlayer1ByName(playerName1);
        Player player2 = findPlayer2ByName(playerName2);

        int roundResult = player1.compareTo(player2);
        return roundResult;


    }
}
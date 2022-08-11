import java.util.Collection;
import java.util.HashMap;

public class Game {
    private Collection<Player> players;
    Repo repository;

    public Game(Repo repository) {
        this.repository = repository;
    }

    public void register(Player player) {
        repository.add(player);

    }
    public Player[] getAll() {
        return repository.findAll().toArray(new Player[0]);
    }

    public Player findByName (String name) {
        Player[] players = repository.findAll().toArray(new Player[0]);

        for (Player player : players) {
            if (player.getName() == name) {
                Player foundPlayer = new Player(player.getId(),player.getName(),player.getStrength());
            }

        }
        return foundPlayer;
    }

    public int round(String playerName1, String playerName2) {
        if (playerName1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + "не найден");
        }
        if (playerName2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + "не найден");
        }
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        int roundResult = player1.compareTo(player2);
        return roundResult;


    }
}
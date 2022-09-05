import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.Player;
import ru.netology.Repo;
import ru.netology.exception.NotRegisteredException;

public class GameTest {

    Repo repository = new Repo();
    Game game = new Game(repository);


    Player player1 = new Player(01, "Anna", 5);
    Player player2 = new Player(02, "Boris", 3);
    Player player3 = new Player(03, "Ira", 7);
    Player player4 = new Player(04, "Roma", 2);
    Player player5 = new Player(05, "Lena", 4);
    Player player6 = new Player(06, "Kate", 3);

    @Test

    public void registerAndGetAllTest() {

        game.register(player1);
        game.register(player2);
        Player actual[] = game.getAll();
        Player expected[] = {player1, player2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesFalseTest() {
        boolean actual = game.matches(player1, "Boris");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesTrueTest() {
        boolean actual = game.matches(player1, "Anna");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void findPlayersBothExistTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);


        Player[] actual = game.findPlayersByName("Anna", "Boris");
        Player[] expected = {player1, player2};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void findPlayersPlayer1NotExistTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.findPlayersByName("Karl", "Ira");
        });

    }

    @Test

    public void FindPlayersPlayer2NotExistTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.findPlayersByName("Anna", "Karl");
        });
    }

    @Test

    public void roundPlayer1WinTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round("Ira", "Boris");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void roundPlayer2WinTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round("Boris", "Ira");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void roundDrawTest() {
        game.register(player1);
        game.register(player2);
        game.register(player6);

        int actual = game.round("Boris", "Kate");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }
}

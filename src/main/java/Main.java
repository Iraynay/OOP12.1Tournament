import java.util.Arrays;

public class Main {

    public static void main (String[] Args) {
        Repo repository = new Repo();

        Player player1 = new Player(01, "Anna", 5);
        Player player2 = new Player(02,"Boris", 3);
        Player player3 = new Player(03,"Ira", 7);
        Player player4 = new Player(04, "Roma", 2);
        Player player5 = new Player(05, "Lena", 4);

        Game game = new Game(repository);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Player [] result1 = game.getAll();
        System.out.println("All players: " + Arrays.toString (result1));
        Player result2 = game.findByName("Roma");
        System.out.println("FindByName: " + result2);

       int result3 = game.round("Roma", "Ira");
        System.out.println("roundResult: " + result3);

    }
}

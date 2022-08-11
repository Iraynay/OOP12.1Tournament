import java.util.ArrayList;
import java.util.Collection;

public class Repo {

    private Collection<Player> players;

    public Repo () {
        this.players = new ArrayList<>();
    }

        public void add (Player player) {
            players.add(player);
        }
        public Collection<Player> findAll() {
        return players;
        }


}

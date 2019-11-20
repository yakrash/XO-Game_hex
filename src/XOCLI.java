import io.bzz.xo.model.Field;
import io.bzz.xo.model.Figure;
import io.bzz.xo.model.Game;
import io.bzz.xo.model.Player;
import io.bzz.xo.view.ConsoleView;

public class XOCLI {

    public static void main(String[] args) {
        String name1 = "Shurik";
        String name2 = "Bot";
        Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);
        Game game = new Game(players, " X O ", new Field());
        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while (consoleView.move(game)){
            consoleView.show(game);
        }

    }
}

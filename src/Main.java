import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Util util = new Util();
        util.StringHello();
        game.getPlayers();
        game.getHeroes();
        util.GetReadyToStart();
        game.Fight();
//        game.getUnits(1, 2);
//        System.out.println(Arrays.toString(game.players));
    }
}
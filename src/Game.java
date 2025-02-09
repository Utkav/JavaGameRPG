import java.util.Arrays;
import java.util.Scanner;

public class Game extends Scenary{
    public static int CountOfPlayers = 2;
    public static int CountOfHeroes = 3;

    public static int Flag = 0; // для того, чтобы выйти из всех циклов и прекратить игру
    Scenary scenary = new Scenary();
    Scanner in = new Scanner(System.in);

    Player[] players = new Player[CountOfPlayers]; // пока здесь массив с 2 игроками
    Unit[][] units = new Unit[CountOfPlayers][CountOfHeroes]; // массив с массивами героев, каждого из игроков

    String[] results = new String[CountOfPlayers];

    public void getPlayers(){
        for (int i = 0; i < CountOfPlayers; i++){
            System.out.print("Введите свое имя: ");
            players[i] = new Player(in.nextLine());
//            System.out.println();

        }
    }

    public void getHeroes(){ // метод позволяет нам сформировать команду для каждого из игроков
        for (int i = 0; i < CountOfPlayers; i++){
            System.out.println(players[i].getName() + " выберите 3-ех персонажей (W, K, T)");
            for (int j = 0; j < CountOfHeroes; j++){
                System.out.println("Введите класс своего " + (j + 1) + " героя");
                String hero = in.nextLine();
                if (hero.equals("W")){
                    units[i][j] = new Wizard();
                } else if (hero.equals("K")){
                    units[i][j] = new Knight();
                } else if (hero.equals("T")){
                    units[i][j] = new Terminator();
                } else {
                    System.out.println("Похоже, что вы не определились с героем, поэтому этот герой будет Knight");
                    units[i][j] = new Knight();
                }
            }
            System.out.println();
        }
        for (int i = 0; i < CountOfPlayers; i++){
            results[i] = "";
        } // заполнени массива results  с целью дальнейшего получения исходов игры
    }

    @Override
    public String toString() {
        return "Game{" +
                "players=" + Arrays.toString(players) +
                '}';
    }

    public void getUnits(int NumbOfPlayer, int WhoseMove) { // Метод позволяет вывести порядок, в котором ходят герои и чей сейчас ход
        for (int i = 0; i < CountOfHeroes; i++){
            if (WhoseMove == -10){ // Это нужно для того, чтобы просто выводить инфу о героях без привязки к ходу
                System.out.print(units[NumbOfPlayer][i].getName() + " ");
            } else {
                if (i != WhoseMove){
                    System.out.print(units[NumbOfPlayer][i].getName().toLowerCase() + " ");
                }
                else {
                    System.out.print(units[NumbOfPlayer][i].getName() + " ");
                }
            }


        }
        System.out.println();
    }

    public void getInfoOfHealth(int NumbOfPlayers){
        for (int i = 0; i < CountOfHeroes; i++){
            System.out.print(units[NumbOfPlayers - 1][i].getHealth() + " ");
        }
        System.out.println();
    }

    public void Fight(){
        while (true){
            System.out.println("Раунд " + Round + " продолжаем.");
            int roundHero = (Round - 1) % CountOfHeroes;

            for (int i = 0; i < CountOfPlayers; i++){
                System.out.println();
                System.out.print(players[i].getName() + " ваша конфигурация сейчас: ");
                getUnits(i, roundHero);
                System.out.println("Выберите противника, которого будете атаковать от 1 до " + CountOfPlayers);
                int Victim = in.nextInt();
                System.out.print("Герои вашего противника: ");
                getUnits(Victim - 1, -10);
                System.out.println("Здоровье каждого героя противника");
                getInfoOfHealth(Victim);
                // сделай выбор кого атаковать и наконец реализуй бой
                System.out.println(players[i].getName() + " выберите любую из " + CountOfHeroes + " целей для атаки");
                int VictimHero = in.nextInt(); // для того, чтобы атаковать конкретного героя
                System.out.println("Цель атакована!");
                units[Victim - 1][VictimHero - 1].getdamage(units[i][roundHero].getPower());
                System.out.println("Результат атаки: ");
                getUnits(Victim - 1, -10);
                getInfoOfHealth(Victim);
                for (int k = 0; k < CountOfPlayers; k++){
                    int countOfZeroes = 0;
                    for (int j = 0; j < CountOfHeroes; j++){
                        if (units[k][j].getHealth() <= 0){
                            countOfZeroes += 1;
                        }
                    }
                    if (countOfZeroes >= CountOfHeroes){
                        results[k] = players[k].getName() + " is lose";
                    }
                }
                int res = 0;
                for (int f = 0; f < CountOfPlayers; f++){
                    if (results[f].equals("")){
                        res += 1;
                    }
                }
                if (res == 1){ // для того, чтобы закончить цикл и эту игру, то есть вывести результаты игры, в которой победил 1 игрок
                    for (int f = 0; f < CountOfPlayers; f++){
                        if (results[f].equals("")){
                            System.out.println(players[f].getName() + " is winning");
                        } else {
                            System.out.println(results[f]);
                        }
                    }
                    Flag = 1;
                    break;
                }

            }
        if (Flag == 1){
            break;
        }
        Round += 1;
        }
    }
}
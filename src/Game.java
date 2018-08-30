import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col ;
    private static int row ;


    public static void main(String[] args){
        ox = new OX();
        while(true){
            printtable();
            input();
            if(ox.checkWin(col,row)){
                printtable();
                System.out.println(ox.getCurrentPlayer()+" win ");
                printScore("X Win:" + ox.getScoreX(), "0 Win:", ox.getScoreO(), " Draw:", ox.getScoreDraw());
                ox.reset();
                continue;
            }
            if(ox.isDrew()){
                printtable();
                printScore("Draw", "X Win:", ox.getScoreX(), "0 Win:", ox.getScoreO());
                System.out.println(" Draw:"+ ox.getScoreDraw());
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }
    }

    private static void printScore(String s, String s2, int scoreO, String s3, int scoreDraw) {
        System.out.println(s);
        System.out.println(s2 + scoreO);
        System.out.println(s3 + scoreDraw);
    }

    private static void input() {
        boolean canPut = true;
        do {
            System.out.println(ox.getCurrentPlayer() + " Col :");
            col = sc.nextInt();
            System.out.println(ox.getCurrentPlayer() + " Row :");
            row = sc.nextInt();
            canPut = ox.put(col, row);
            if (!canPut) {
                System.out.println("Please input number between 0-2 ");
            }
        }while (!canPut);
    }

    private static void printtable() {
        System.out.print(ox.getTableString());
    }
}

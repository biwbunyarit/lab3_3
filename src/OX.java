public class OX {
    String table[][] = {{" ","0","1","2"},
                        {"0","-","-","-"},
                        {"1","-","-","-"},
                        {"2","-","-","-"},
    };
    private String CurrentPlayer;
    private int turncount;
    private int scoreX;
    private int scoreO;
    private int scoreDraw;

    public OX(){
        CurrentPlayer = "X";
        turncount = 0 ;
        scoreX = 0 ;
        scoreO = 0 ;
        scoreDraw = 0;

    }

    public String getTableString() {
        String result = "";
        for(int i=0 ; i<4 ; i++){
            for(int j=0 ; j<4 ; j++){
                result = result + table[i][j];
            }
            result = result + "\n";
        }
        return result ;
    }

    public String getCurrentPlayer() {
        return CurrentPlayer;
    }

    public void switchPlayer() {
        if(CurrentPlayer.equals("X")){
            CurrentPlayer = "O";
        }else{
            CurrentPlayer = "X";
        }
    }

    public boolean put(int col, int row) {
        try{
            if(!table[row+1][col+1].equals("-")){
                return false ;
            }
            table[row+1][col+1] = CurrentPlayer;

        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
        turncount++;
        if (checkWin(col,row)){
            if (CurrentPlayer.equals("X")){
                scoreX++;
            }else if (CurrentPlayer.equals("O")){
                scoreO++;
            }
        }
        if (isDrew()){
            scoreDraw++;
        }

        return true;
    }

    public String get(int col, int row) {
        if(col > 2 || col <0 || row > 2 || row <0){
            return null;
        }


        return table[row+1][col+1];
    }

    public boolean checkWin(int col, int row) {
        boolean colWin = true;
        for (int i=0 ;i<3 ;i++){
            if(!table[i+1][col+1].equals(CurrentPlayer)){
                colWin = false;
            }
        }
        if(colWin){
            return true;
        }

        boolean rowWin = true;
        for (int i=0 ;i<3 ;i++){
            if(!table[row+1][i+1].equals(CurrentPlayer)){
                rowWin = false;
            }
        }
        if(rowWin){
            return true;
        }

        boolean esWin = true;
        for (int i=0 ;i<3 ;i++){
            if(!table[i+1][i+1].equals(CurrentPlayer)){
                esWin = false;
            }
        }
        if(esWin){
            return true;
        }

        boolean ssWin = true;
        for (int i=0 ;i<3 ;i++){
            if(!table[i+1][3-i].equals(CurrentPlayer)){
                ssWin = false;
            }
        }
        if(ssWin){
            return true;
        }


            return false;
    }

    public void reset() {
        for(int i=0 ;i<3 ; i++){
            for(int j = 0 ;j<3 ; j++){
                table[i+1][j+1] = "-";
            }
        }
        CurrentPlayer = "X";
        turncount = 0;
    }

    public int getTurnCount() {
        return turncount;
    }

    public boolean isDrew() {
        if(turncount < 9 ){
            return false;
        }
        return true;
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public int getScoreDraw() {
        return scoreDraw;
    }
}

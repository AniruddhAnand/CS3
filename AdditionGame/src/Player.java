public class Player {
    private int score;
    private int strikes;
    public Player(){
        score = 0;
        strikes = 3;
    }
    public void incement(){
        score++;
    }
    public void decriment(){
        strikes--;
    }
    public boolean isAlaive(){
        return strikes>0;
    }

    public int getScore() {
        return score;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FireModel
{
    public static boolean isTrouble = false;
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    public void fire(int n, int m){
        if(n==0){
            isTrouble = true;
        }
        myView.updateView(myGrid);
        if(n+1<SIZE){
            if(myGrid[n+1][m].getStatus()==FireCell.GREEN){
                myGrid[n+1][m].setStatus(FireCell.BURNING);
                fire(n+1,m);
            }
        }
        if(n-1>-1){
            if(myGrid[n-1][m].getStatus()==FireCell.GREEN){
                myGrid[n-1][m].setStatus(FireCell.BURNING);
                fire(n-1,m);
            }
        }
        if(m+1<SIZE){
            if(myGrid[n][m+1].getStatus()==FireCell.GREEN){
                myGrid[n][m+1].setStatus(FireCell.BURNING);
                fire(n,m+1);
            }
        }
        if(m-1>-1){
            if(myGrid[n][m-1].getStatus()==FireCell.GREEN){
                myGrid[n][m-1].setStatus(FireCell.BURNING);
                fire(n,m-1);
            }
        }
        try{
        TimeUnit.MILLISECONDS.sleep(3);}
        catch (InterruptedException e){

        }
    }

    public void solve()
    {
        // student code here
        for(int i=0;i<myGrid[SIZE-1].length;i++){
            if(myGrid[SIZE-1][i].getStatus()==FireCell.GREEN){
                fire(SIZE-1,i);
                myView.updateView(myGrid);
            }
        }
        myView.updateView(myGrid);
        if(isTrouble){
            System.out.println("Onett is in trouble");
        }else{
            System.out.println("Onett is safe");
        }
    }

}

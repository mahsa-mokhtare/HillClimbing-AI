package com.company.eightPuzzle;

public class Rules {

    public boolean moveRule(char [][]matrix,int[]coordinate,int move)
    {
        boolean bol=true;
        int x = coordinate[0];
        int y = coordinate[1];

        switch (move)
        {
            case 1:
                if (x == 0)
                {
                    bol =  false;
                }
                break;

            case 2:
                if(y == 2)
                {
                    bol =  false;
                }
                break;
            case 3:
                if(x ==2)
                {
                    bol =  false;
                }
                break;
            case 4:
                if( y==0)
                {
                    bol =  false;
                }
                break;


        }
        return bol;
    }
}

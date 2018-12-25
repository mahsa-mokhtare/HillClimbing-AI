package com.company.eightPuzzle;

public class Rules {
    Config config = new Config();

    public boolean moveRule(char [][]matrix,int[]cordinate,int move)
    {
        int [] tempcordinate;
        tempcordinate =config.copyCordinate(cordinate);
        boolean bol=true;
        int x = tempcordinate[0];
        int y = tempcordinate[1];

        switch (move)
        {
            case 1:
                if (x == 0)
                {
                    bol = false;
                }
                break;

            case 2:
                if(y == 2)
                {
                    bol = false;
                }
                break;
            case 3:
                if(x ==2)
                {
                    bol = false;
                }
                break;
            case 4:
                if( y==0)
                {
                    bol = false;
                }
                break;


        }
        return bol;
    }
}

package com.company.eightQueen;

public class Rules {
    public boolean moveRule(char [][]matrix,int[]coordinate,int move)
    {
        boolean bol=true;
        int x = coordinate[0];
        int y = coordinate[1];

        switch (move)
        {
            case 1:
                if (x==0 && matrix[x-1][y]=='1')
                {
                    bol=false;
                }
                break;
            case 2:
                if (y==7  && matrix[x-1][y+1]=='1' && x==0)
                {
                    bol = false;
                }
                break;
            case 3:
                if(y==7 && matrix[x][y+1]=='1')
                {
                    bol = false;
                }
                break;
            case 4:
                if(x==7 && y==7 && matrix[x+1][y+1]=='1')
                {
                    bol =false;
                }
                break;
            case 5:
                if(x==7 && matrix[x+1][y]=='1')
                {
                    bol =false;
                }
                break;
            case 6:
                if(x==7 && y==0 && matrix[x+1][y-1]=='1')
                {
                    bol=false;
                }
                break;
            case 7:
                if(y==0 && matrix[x][y-1]=='1')
                {
                    bol = false;
                }

                break;
            case 8:
                if(x==0 && y==0 && matrix[x-1][y-1]=='1')
                {
                    bol=false;
                }
                break;
        }
        return bol;
    }
}

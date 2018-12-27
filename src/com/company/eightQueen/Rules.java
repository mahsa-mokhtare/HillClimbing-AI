package com.company.eightQueen;

public class Rules {
    public boolean moveRule(char [][]matrix,int[]coordinate,int move)
    {
        Config config = new Config();
        char tempmatrix[][] = config.copyMatrix(matrix);
        int tempcoordinate [] = config.copyCordinate(coordinate);
        boolean bol=false;
        int x = tempcoordinate[0];
        int y = tempcoordinate[1];

        switch (move)
        {
            case 1:
                if (x!=0 && tempmatrix[x-1][y]!='1')
                {
                    bol=true;
                }
                break;
            case 2:
                if (y!=7 && x!=0  && tempmatrix[x-1][y+1]!='1')
                {
                    bol = true;
                }
                break;
            case 3:
                if(y!=7 && tempmatrix[x][y+1]!='1')
                {
                    bol = true;
                }
                break;
            case 4:
                if(x!=7 && y!=7 && tempmatrix[x+1][y+1]!='1')
                {
                    bol =true;
                }
                break;
            case 5:
                if(x!=7 && tempmatrix[x+1][y]!='1')
                {
                    bol =true;
                }
                break;
            case 6:
                if(x!=7 && y!=0 && tempmatrix[x+1][y-1]!='1')
                {
                    bol=true;
                }
                break;
            case 7:
                if(y!=0 && tempmatrix[x][y-1]!='1')
                {
                    bol = true;
                }

                break;
            case 8:
                if(x!=0 && y!=0 && tempmatrix[x-1][y-1]!='1')
                {
                    bol=true;
                }
                break;
        }
        return bol;
    }
}

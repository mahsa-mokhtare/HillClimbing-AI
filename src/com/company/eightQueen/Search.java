package com.company.eightQueen;

import java.util.ArrayList;

public class Search {
    State state = new State();
    Config config = new Config();
    public ArrayList<int[]> findQueens(char matrix[][])
    {   ArrayList<int[]> cordinateOfQueens = new ArrayList<>();
        char[][] tempMatrix = config.copyMatrix(matrix);

        for (int i=0; i<tempMatrix.length;i++)
        {
            for(int j=0;j<tempMatrix.length;j++)
            {
                int cordinate[] = new int[2];
                if(tempMatrix[i][j]=='1'){
                    cordinate[0]=i;
                    cordinate[1] =j;
                    tempMatrix[i][j]='0';
                    cordinateOfQueens.add(cordinate);
                }
            }
        }
        return cordinateOfQueens;
    }
    public int heuristic(char matrix[][]) {
        ArrayList<int[]> temp = config.copyList(findQueens(config.copyMatrix(matrix)));
        int cost = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] queenOne = temp.get(0);
            temp.remove(0);
            int iQueenone = queenOne[0];
            int jQueenOne = queenOne[1];
            for (int j = 0; j < temp.size() -1; j++) {
                if (i == j) {
                    continue;

                } else {
                    int[] anotherQueen = temp.get(j);
                    int ianotherQueen = anotherQueen[0];
                    int janotherQueen = anotherQueen[1];
                    if (iQueenone == ianotherQueen || jQueenOne == janotherQueen || iQueenone + jQueenOne == ianotherQueen + janotherQueen || iQueenone - jQueenOne == ianotherQueen - janotherQueen) {
                        cost++;
                    }
                }
            }

        }

        return cost;
    }

    public boolean isGoalState(char[][] matrix) {

        if(heuristic(matrix) == 0) {
            return true;
        }
        return false;
    }

}

package com.company.eightQueen;

import java.util.ArrayList;

public class Search {

    public ArrayList<int[]> findQueens(char matrix[][])
    {   ArrayList<int[]> cordinateOfQueens = new ArrayList<>();
        int cordinate[] = new int[2];
        for (int i=0; i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(matrix[i][j]=='1'){
                    cordinate[0]=i;
                    cordinate[1] =j;
                    matrix[i][j]='0';
                    cordinateOfQueens.add(cordinate);
                }
            }
        }
        return cordinateOfQueens;
    }
    private int heuristic(ArrayList<int[]> queens,char matrix[][]) {
        int cost = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] queenOne = queens.get(0);
            int iQueenone = queenOne[0];
            int jQueenOne = queenOne[1];

            for (int j = 0; j < queens.size() - 1; i++) {
                if (i == j) {
                    continue;

                } else {
                    int[] anotherQueen = queens.get(j);
                    int ianotherQueen = anotherQueen[0];
                    int janotherQueen = anotherQueen[1];

                    if (iQueenone == ianotherQueen || jQueenOne == janotherQueen || iQueenone + jQueenOne == ianotherQueen + janotherQueen || iQueenone - jQueenOne == ianotherQueen - janotherQueen) {
                        cost++;
                    }
                }
            }
            queens.remove(0);
        }
        return ++cost;
    }
}

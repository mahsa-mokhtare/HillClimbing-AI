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
    public int heuristic(ArrayList<int[]> queens,char matrix[][]) {
        ArrayList<int[]> temp = config.copyList(queens);
        int cost = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] queenOne = temp.get(0);
            int iQueenone = queenOne[0];
            int jQueenOne = queenOne[1];
            //System.out.printf("%d,%d\n",iQueenone,jQueenOne);
            for (int j = 1; j < temp.size(); j++) {
                if (i == j) {
                    continue;

                } else {
                    int[] anotherQueen = temp.get(j);
                    int ianotherQueen = anotherQueen[0];
                    int janotherQueen = anotherQueen[1];
                    //System.out.printf("%d,%d\n",ianotherQueen,janotherQueen);
                    System.out.printf("%d,%d,%d,%d\n",iQueenone - ianotherQueen,jQueenOne - janotherQueen,iQueenone + jQueenOne - ianotherQueen + janotherQueen,iQueenone - jQueenOne -( ianotherQueen - janotherQueen));
                    if (iQueenone == ianotherQueen || jQueenOne == janotherQueen || iQueenone + jQueenOne == ianotherQueen + janotherQueen || iQueenone - jQueenOne == ianotherQueen - janotherQueen) {
                        cost++;
                    }
                }
            }
            //System.out.println("============================");
            temp.remove(0);
        }

        return cost;
    }

    public boolean isGoalState(char[][] matrix) {

        if(heuristic(findQueens(matrix), matrix) == 0) {
            return true;
        }
        return false;
    }

}

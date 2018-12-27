package com.company.eightQueen;

import java.util.ArrayList;

public class Successor {

    Config config = new Config();
    Move move = new Move();
    Rules rules = new Rules();
    Search search = new Search();
    State state = new State();



    public ArrayList<ArrayList> getSuccessor(char matrix[][])
    {
        char [][] tempMatrix;
        int heuristic;

        char [][] matrixmove;

        ArrayList<int[]> queens = search.findQueens(matrix);
        ArrayList<ArrayList> huersAndMatrix = new ArrayList<>();
        for(int i = 0;i<8;i++) {

            for (int k = 1; k <= 8; k++) {
                tempMatrix = config.copyMatrix(matrix);

                if (rules.moveRule(tempMatrix, queens.get(i), k)) {

                    matrixmove = move.movement(tempMatrix, queens.get(i), k);
                    ArrayList<int[]> tempQueen  = search.findQueens(matrixmove);
                    heuristic = search.heuristic(tempQueen, matrixmove);
                    ArrayList temp = new ArrayList<>();
                    state.printMatrix(matrixmove);
                    System.out.println(heuristic);
                    temp.add(matrixmove);
                    temp.add(heuristic);
                    huersAndMatrix.add(temp);
                }
            }
        }

        return huersAndMatrix;
    }

    public ArrayList getBestSuccessor(ArrayList<ArrayList> successor) {

        ArrayList bestSuccessor = new ArrayList();
        int m=1000;
        int index = 0;
        for(int i=0; i<successor.size();i++)
        {
            if((int) successor.get(i).get(1)<m) {
                m = (int) successor.get(i).get(1);
                index = i;
            }


        }


        bestSuccessor.add(successor.get(index).get(0));
        bestSuccessor.add(successor.get(index).get(1));
        return bestSuccessor;


    }

}

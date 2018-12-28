package com.company.eightQueen;

import java.util.ArrayList;
import java.util.Random;

public class Successor {

    Config config = new Config();
    Move move = new Move();
    Rules rules = new Rules();
    Search search = new Search();
    State state = new State();



    public ArrayList<ArrayList> getSuccessor(char matrix[][])
    {
        char [][] tempMatrix = config.copyMatrix(matrix);


        char [][] matrixmove;

        ArrayList<int[]> queens = search.findQueens(tempMatrix);
        ArrayList<ArrayList> huersAndMatrix = new ArrayList<>();
        for(int i = 0;i<8;i++) {
            int[] tempQueen = queens.get(i);
            for (int k = 1; k <= 8; k++) {
                tempMatrix = config.copyMatrix(matrix);
                ArrayList temp = new ArrayList<>();
                if (rules.moveRule(tempMatrix, tempQueen, k)) {
                    int heuristic;
                    matrixmove = move.movement(tempMatrix, tempQueen, k);
                    heuristic = search.heuristic(matrixmove);
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
            int tc = (int) successor.get(i).get(1);
            if(tc < m) {
                m = tc;
                index = i;
            }


        }


        bestSuccessor.add(successor.get(index).get(0));
        bestSuccessor.add(successor.get(index).get(1));
        return successor.get(index);


    }

    public ArrayList getFirstSuccessor(ArrayList<ArrayList> successor,char[][]matrix)
    {
        ArrayList firstSuccessor = new ArrayList();
        int m= search.heuristic(matrix);
        int index = 0;
        for(int i=0; i<successor.size();i++)
        {
            if((int) successor.get(i).get(1)<m)
            {
                m= (int) successor.get(i).get(1);
                index =i;
            }
        }
        firstSuccessor.add(successor.get(index).get(0));
        firstSuccessor.add(successor.get(index).get(1));
        return firstSuccessor;

    }
    public ArrayList getRandomSuccesor(ArrayList<ArrayList> randomSuccesor) {

        Random random = new Random();
        int randi = random.nextInt(randomSuccesor.size());
        return randomSuccesor.get(randi);

    }

}

package com.company.eightPuzzle;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Random;


public class Successor {

    State state = new State();
    Move moveClass = new Move();
    Search search = new Search();
    Rules rules = new Rules();
    Config config = new Config();

    public ArrayList<ArrayList> getSuccessor(char matrix[][],char goal[][])
    {
        char [][] tempMatrix;
        char [][] tempGoal;
        int heuristic;

        int cordinateEmptyNode[];
        tempMatrix = config.copyMatrix(matrix);
        cordinateEmptyNode =state.findEmptyState(tempMatrix);

        char [][] matrixmove = new char[3][3];

        int  move[] = new int[4];
        move[0]=1;
        move[1]=2;
        move[2]=3;
        move[3]=4;

        ArrayList<ArrayList> huersAndMatrix = new ArrayList<>();


        for(int k=0; k<move.length; k++)
        {
            tempGoal = config.copyMatrix(goal);
            tempMatrix = config.copyMatrix(matrix);
            int movement =move[k];
            if(rules.moveRule(tempMatrix,cordinateEmptyNode,movement)) {

                matrixmove = moveClass.movement(tempMatrix, cordinateEmptyNode, movement);
                heuristic = search.ManhatanDistance(matrixmove, tempGoal);
                ArrayList temp = new ArrayList<>();
                temp.add(matrixmove);
                temp.add(heuristic);
                huersAndMatrix.add(temp);
            }


        }


        return huersAndMatrix;
    }

    public ArrayList getBestSuccessor(ArrayList<ArrayList> successor) {

        ArrayList bestSuccessor = new ArrayList();
        int m=100;
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
    public ArrayList getFirstSuccessor(ArrayList<ArrayList> successor,char[][]matrix)
    {
        ArrayList firstSuccessor = new ArrayList();
        int m= search.ManhatanDistance(matrix,config.goalState());
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


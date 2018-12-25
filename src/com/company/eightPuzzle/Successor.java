package com.company.eightPuzzle;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Successor {

    State state = new State();
    Move moveClass = new Move();
    Search search = new Search();
    Rules rules = new Rules();
    Config config = new Config();

    public ArrayList<ArrayList> getSuccessor(char matrix[][],char goal[][])
    {

        boolean bol;
        char [][] tempMatrix;



      /*  int [] cordinatetempMatrix = new int[2];
        int XcordinatetempMatrix =cordinatetempMatrix[0];
        int YcordinatetempMatrix = cordinatetempMatrix[1];
        */

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



}


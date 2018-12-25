package com.company;

import com.company.eightPuzzle.Move;
import com.company.eightPuzzle.Search;
import com.company.eightPuzzle.State;
import com.company.eightPuzzle.Successor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Successor successor = new Successor();
        State state = new State();
        char [][] goalState = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', ' '}};
        char [][] currentState={{'4', '1', '2' }, {' ', '5', '3'}, {'7', '8', '6'}};
        int []cordinate= state.findEmptyState(currentState);
        char [][] newma = new char[3][3];


        com.company.eightPuzzle.Search search = new Search();

        ArrayList<ArrayList> successorss = successor.getSuccessor(currentState,goalState);
        for(int i=0;i<successorss.size();i++){
            state.printMatrix((char[][]) successorss.get(i).get(0));
            System.out.println((int) successorss.get(i).get(1));
        }


       /* Move move  = new Move();
        newma=move.movement(currentState,cordinate,4);
        state.printMatrix(newma);
        */

     /*  cordinate=state.findEmptyState(currentState);
        System.out.println(cordinate[1]);
        */
        System.out.println(search.ManhatanDistance(currentState,goalState));

    }
}

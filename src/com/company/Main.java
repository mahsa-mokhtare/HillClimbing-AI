package com.company;

import com.company.eightPuzzle.*;
import com.company.hillClimbing.HillAlgorithm;
import com.company.hillClimbing.Node;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Successor successor = new Successor();
        State state = new State();
        HillAlgorithm hillAlgorithm = new HillAlgorithm();
        Search search = new Search();

        Config config = new Config();
        char [][] goalState = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', ' '}};
        char [][] currentState={{'4', '1', '2' }, {' ', '5', '3'}, {'7', '8', '6'}};

        Node node = new Node(currentState,0,search.ManhatanDistance(currentState,goalState));


        int []cordinate= state.findEmptyState(currentState);
        char [][] newma = new char[3][3];
        ArrayList<ArrayList> array = new ArrayList<>();


       // com.company.eightPuzzle.Search search = new Search();

      /*   ArrayList<ArrayList> successorss = successor.getSuccessor(currentState,goalState);
        for(int i=0;i<successorss.size();i++){
            state.printMatrix((char[][]) successorss.get(i).get(0));
            System.out.println((int) successorss.get(i).get(1));
        }
        */



       /* Move move  = new Move();
        newma=move.movement(currentState,cordinate,4);
        state.printMatrix(newma);
        */

     /*  cordinate=state.findEmptyState(currentState);
        System.out.println(cordinate[1]);
        */
       // System.out.println(search.ManhatanDistance(currentState,goalState));

     /*  array =successor.getSuccessor(currentState,goalState);
        successor.getBestSuccessor(array);
        */

     int steepestAscentSolved=0;
     for(int i=0; i<1000;i++) {
         char[][] init = state.makeRandomMatrix(goalState);
         if(config.isGoalState(hillAlgorithm.simulatedAnnealing(init).state,config.goalState())){
             steepestAscentSolved++;
         }

     }

        System.out.println(steepestAscentSolved);


    }
}

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

        com.company.eightQueen.Search searchQueen = new com.company.eightQueen.Search();
        com.company.eightQueen.State stateQueen = new com.company.eightQueen.State();
        com.company.eightQueen.Config configQueen = new com.company.eightQueen.Config();

        Config config = new Config();
        char[][] goalState = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', ' '}};
        char[][] currentState = {{'4', '1', '2'}, {' ', '5', '3'}, {'7', '8', '6'}};




        /*
         * Algorithms for 8puzzle
         */
        int steepestAscentSolved = 0;
        int firstChoiceSolved = 0;
        int simulatedAnnealingSolved = 0;
        for (int i = 0; i < 1000; i++) {
            char[][] init = state.makeRandomMatrix(goalState);
            if (config.isGoalState(hillAlgorithm.steepestAscentEightPuzzle(init).state, config.goalState())) {
                steepestAscentSolved++;
            }

            if (config.isGoalState(hillAlgorithm.firstChoiceEightPuzzle(init).state, config.goalState())) {
                firstChoiceSolved++;
            }

            if (config.isGoalState(hillAlgorithm.simulatedAnnealingEightPuzzle(init).state, config.goalState())) {
                simulatedAnnealingSolved++;
            }

        }

        System.out.println(steepestAscentSolved);
        System.out.println(firstChoiceSolved);
        System.out.println(simulatedAnnealingSolved);

        /*
         * Algorithms for 8queens
         */

        steepestAscentSolved = 0;
        firstChoiceSolved = 0;
        simulatedAnnealingSolved = 0;
        for (int i = 0; i < 100; i++) {
            char[][] init = stateQueen.makeRandomMatrix(stateQueen.initialState());
            if (searchQueen.isGoalState(hillAlgorithm.steepestAscentEightQueen(init).state)) {
                steepestAscentSolved++;
            }

            if (searchQueen.isGoalState(hillAlgorithm.firstChoiceEightQueens(init).state)) {
                firstChoiceSolved++;
            }

            if (searchQueen.isGoalState(hillAlgorithm.simulatedAnnealingEightQueens(init).state)) {
                simulatedAnnealingSolved++;
            }

        }

        System.out.println(steepestAscentSolved);
        System.out.println(firstChoiceSolved);
        System.out.println(simulatedAnnealingSolved);

    }



}

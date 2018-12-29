package com.company;

import com.company.eightPuzzle.*;
import com.company.hillClimbing.HillAlgorithm;
import com.company.hillClimbing.Node;
import java.text.NumberFormat;
import java.util.Locale;

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

        int coststeepestAscentSolved =0;
        int costfirstChoiceSolved =0;
        int costsimulatedAnnealingSolved=0;

        for (int i = 0; i < 1000; i++) {
            char[][] init = state.makeRandomMatrix(goalState);
            if (config.isGoalState(hillAlgorithm.steepestAscentEightPuzzle(init).state, config.goalState())) {
                steepestAscentSolved++;
                coststeepestAscentSolved = coststeepestAscentSolved + hillAlgorithm.steepestAscentEightPuzzle(init).cost;

            }


            if (config.isGoalState(hillAlgorithm.firstChoiceEightPuzzle(init).state, config.goalState())) {
                firstChoiceSolved++;
                costfirstChoiceSolved = costfirstChoiceSolved +hillAlgorithm.firstChoiceEightPuzzle(init).cost;

            }


            if (config.isGoalState(hillAlgorithm.simulatedAnnealingEightPuzzle(init).state, config.goalState())) {
                simulatedAnnealingSolved++;
                costsimulatedAnnealingSolved = costsimulatedAnnealingSolved + hillAlgorithm.simulatedAnnealingEightPuzzle(init).cost;

            }

        }

        float sumPuzzle1 = (float)coststeepestAscentSolved/(float) steepestAscentSolved;
        float sumPuzzle2 = (float)costfirstChoiceSolved/(float) firstChoiceSolved;
        float sumPuzzle3 = (float)costsimulatedAnnealingSolved/(float) simulatedAnnealingSolved;



        System.out.println("*************************************************************************************************************************************");
        System.out.println("-----------------------------------------------------8Puzzle Algorithms--------------------------------------------------------------");
        System.out.println("*************************************************************************************************************************************\n");

        int number = steepestAscentSolved;
        float percentage = (float) number/(float)1000 * (float)100;
        System.out.println("1-steepestAscentSolved                            for 1000 attempts: "+percentage + "                           cost :"+sumPuzzle1+"\n");

        int number1 =firstChoiceSolved ;
        float percentage1 = (float) number1/(float)1000 * (float)100;

        System.out.println("2-FistChoice                                      for 1000 attempts: "+percentage1+ "                           cost :"+sumPuzzle2+"\n");

        int number2=simulatedAnnealingSolved ;
        float percentage2 = (float) number2/(float)1000 * (float)100;

        System.out.println("3-SimulatedAnnealing                              for 1000 attempts: "+percentage2+ "                          cost :"+sumPuzzle3+"\n");







        /*
         * Algorithms for 8queens
         */

        steepestAscentSolved = 0;
        firstChoiceSolved = 0;
        simulatedAnnealingSolved = 0;

         coststeepestAscentSolved =0;
         costfirstChoiceSolved =0;
         costsimulatedAnnealingSolved=0;
        for (int i = 0; i < 100; i++) {
            char[][] init = stateQueen.makeRandomMatrix(stateQueen.initialState());
            if (searchQueen.isGoalState(hillAlgorithm.steepestAscentEightQueen(init).state)) {
                steepestAscentSolved++;
                coststeepestAscentSolved = coststeepestAscentSolved +hillAlgorithm.steepestAscentEightQueen(init).cost;
            }

            if (searchQueen.isGoalState(hillAlgorithm.firstChoiceEightQueens(init).state)) {
                firstChoiceSolved++;
                costfirstChoiceSolved = costfirstChoiceSolved + hillAlgorithm.firstChoiceEightQueens(init).cost;
            }

            if (searchQueen.isGoalState(hillAlgorithm.simulatedAnnealingEightQueens(init).state)) {
                simulatedAnnealingSolved++;
                costsimulatedAnnealingSolved = costsimulatedAnnealingSolved + hillAlgorithm.simulatedAnnealingEightQueens(init).cost;
            }

        }
        float sumQueen1 = (float) coststeepestAscentSolved/(float)steepestAscentSolved;
        float sumQueen2= (float) costfirstChoiceSolved/(float)firstChoiceSolved;
        float sumQueen3 =(float) costsimulatedAnnealingSolved/(float)simulatedAnnealingSolved;

        System.out.println("*************************************************************************************************************************************");
        System.out.println("--------------------------------------------------8Queen Algorithms------------------------------------------------------------------");
        System.out.println("**************************************************************************************************************************************\n");

        int numberQ = steepestAscentSolved;
        float percentageQ = (float) numberQ/(float)100 * (float)100;
        System.out.println("1-steepestAscentSolved                            for 100 attempts:" +percentageQ+"                              cost :"+sumQueen1+"\n");
        int numberQ1 = firstChoiceSolved;
        float percentageQ1 = (float) numberQ1/(float)100 * (float)100;
        System.out.println("2-FistChoice                                      for 100 attempts:" +percentageQ1+"                             cost :"+sumQueen2+"\n");
        int numberQ2 = simulatedAnnealingSolved;
        float percentageQ2 = (float) numberQ2/(float)100 * (float)100;
        System.out.println("3-SimulatedAnnealing                              for 100 attempts:" +percentageQ2+"                           cost :"+sumQueen3+"\n");







    }



}

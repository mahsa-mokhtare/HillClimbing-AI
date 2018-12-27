package com.company.hillClimbing;

import com.company.eightPuzzle.Config;
import com.company.eightPuzzle.Search;
import com.company.eightPuzzle.State;
import com.company.eightPuzzle.Successor;

import java.util.ArrayList;

public class HillAlgorithm {

    Search search = new Search();
    Successor successor = new Successor();
    Config config = new Config();
    State state = new State();


    com.company.eightQueen.Search searchQueen = new com.company.eightQueen.Search();
    com.company.eightQueen.Successor successorQueen = new com.company.eightQueen.Successor();
    com.company.eightQueen.Config configQueen = new com.company.eightQueen.Config();
    com.company.eightQueen.State stateQueen = new com.company.eightQueen.State();


    public Node SteepestAscentEightPuzzle(char[][]currentState) {

        Node current = new Node(currentState,0,search.ManhatanDistance(currentState,config.goalState()));
        while(true)
        {


            ArrayList bestSuccessor = successor.getBestSuccessor(successor.getSuccessor(current.state,config.goalState()));
            Node neighbor = new Node((char[][])bestSuccessor.get(0),++current.cost,(int)bestSuccessor.get(1));
            if(neighbor.value>= current.value)
            {

                return current;

            }
            current = neighbor;
        }



    }
    public Node steepestAscentEightQueen(char[][]currentState) {


        Node current = new Node(currentState,0,searchQueen.heuristic(searchQueen.findQueens(currentState),currentState));
        stateQueen.printMatrix(current.state);
        System.out.println(current.value);
        while(true)
        {




            ArrayList bestSuccessor = successorQueen.getBestSuccessor(successorQueen.getSuccessor(current.state));
            Node neighbor = new Node((char[][])bestSuccessor.get(0),++current.cost,(int)bestSuccessor.get(1));

            if(neighbor.value>= current.value)
            {
                stateQueen.printMatrix(neighbor.state);
                System.out.println(neighbor.value);
                System.out.println("=================================");
                return current;

            }
            current = neighbor;
        }



    }




    public Node firstChoiceEightPuzzle(char [][]currentState)
    {
        Node current = new Node(currentState,0,search.ManhatanDistance(currentState,config.goalState()));
        while(true)
        {
            ArrayList firstSuccessor = successor.getFirstSuccessor(successor.getSuccessor(current.state,config.goalState()),currentState);
            Node neighbor = new Node((char[][])firstSuccessor.get(0),++current.cost,(int)firstSuccessor.get(1));
            if(neighbor.value>= current.value)
            {

                return current;

            }
            current = neighbor;
        }

    }

    public Node simulatedAnnealing (char[][] currentState) {
        Node current = new Node(currentState, 0, search.ManhatanDistance(currentState, config.goalState()));

        while (true) {
            ArrayList randomSuccessor = successor.getRandomSuccesor(successor.getSuccessor(current.state, config.goalState()));
            Node neighbor = new Node((char[][]) randomSuccessor.get(0), ++current.cost, (int) randomSuccessor.get(1));

            int temperatureNeighbor = neighbor.value;
            int temperatureCurrent = current.value;
            int delta = temperatureCurrent - temperatureNeighbor;

            if (temperatureCurrent == 0) {

                return current;
            }

            if (delta > 0) {
                current = neighbor;
            } else {
                double function = Math.exp((double)delta/ (double)temperatureCurrent);
                double random = Math.random();
                if(random>function){
                    current = neighbor;
                }
            }


        }
    }
}






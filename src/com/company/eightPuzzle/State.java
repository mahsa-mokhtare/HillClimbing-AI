package com.company.eightPuzzle;

import java.util.Random;

public class State {
    Random rand = new Random();
    /**
     * represents the eight puzzle goal:
     * -------------
     * | 1 |   | 2 |
     * -------------
     * | 3 | 4 | 5 |
     * -------------
     * | 6 | 7 | 8 |
     * -------------
     * <p>
     * In this class we are going to make 12 state of eight puzzle ,that 12 state can be solved.
     */
    Move moveRnadomEmptyState = new Move();
    Rules rules = new Rules();
    Config config = new Config();
    public char[][] initialState() {
        char basicMatrix[][] = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', ' '}};
        return basicMatrix;
    }

    public int[] findEmptyState(char[][] matrix) {
        int[] coordinate = new int[2];
        char [][] tempmatrix = config.copyMatrix(matrix);
        for (int i = 0; i < tempmatrix.length; i++) {
            for (int j = 0; j < tempmatrix.length; j++) {
                if (tempmatrix[i][j] == ' ') {
                    coordinate[0] = i;
                    coordinate[1] = j;
                }
            }
        }
        return coordinate;
    }
    public char[][] makeRandomMatrix(char [][] basicMatrix)
    {
        char randomMatrix[][] = basicMatrix;
        /* this random is for : which move choose*/

        int whichMove = rand.nextInt(4) + 1;



        /*this random is for: how much that state should move*/
        int randomNumMove = rand.nextInt(100) + 2;


        System.out.println(randomNumMove);
        for (int i = 0; i < randomNumMove; i++) {
            while (!rules.moveRule(randomMatrix,findEmptyState(randomMatrix), whichMove)){
                whichMove = rand.nextInt(4) + 1;
            }
            randomMatrix = moveRnadomEmptyState.movement(randomMatrix, findEmptyState(randomMatrix), whichMove);

        }

        return randomMatrix;

    }


    public void printMatrix(char a[][]){


        System.out.println("");
        System.out.println("-------------");
        for (int i = 0; i < a.length; i++) {
            System.out.print("| ");

            for (int j = 0; j < a.length; j++) {

                System.out.print(a[i][j] + " | ");
            }
            System.out.println(" ");
        }
        System.out.println("-------------\n\n");


    }







    }


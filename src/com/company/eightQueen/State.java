package com.company.eightQueen;

import java.util.Random;

public class State {

    Random rand = new Random();
    Config config = new Config();

    public char[][] initialState() {
        char basicMatrix[][] = {
                {'0', '0', '0', '0','0', '0', '0', '0'},
                {'0', '0', '0', '0','0', '0', '0', '0'},
                {'0', '0', '0', '0','0', '0', '0', '0'},
                {'0', '0', '0', '0','0', '0', '0', '0'},
                {'0', '0', '0', '0','0', '0', '0', '0'},
                {'0', '0', '0', '0','0', '0', '0', '0'},
                {'0', '0', '0', '0','0', '0', '0', '0'},
                {'0', '0', '0', '0','0', '0', '0', '0'}};
        return basicMatrix;
    }


    public char[][] makeRandomMatrix(char [][] basicMatrix)
    {
        char randomMatrix[][] = config.copyMatrix(basicMatrix);


        int x = rand.nextInt(7);
        int y = rand.nextInt(7);


        for (int i = 0; i < 8; i++) {
            while (randomMatrix[x][y]=='1'){
                x = rand.nextInt(7);
                y = rand.nextInt(7);
            }


            randomMatrix[x][y] = '1';

        }

        return randomMatrix;

    }


    public void printMatrix(char a[][]){


        System.out.println("");
        System.out.println("-----------------");
        for (int i = 0; i < a.length; i++) {
            System.out.print("|");

            for (int j = 0; j < a.length; j++) {
                if(a[i][j]=='0'){
                    System.out.print(' ');
                }else{
                    System.out.print('q');
                }
                System.out.print("|");
            }
            System.out.println(" ");
        }
        System.out.println("-----------------\n\n");


    }
}

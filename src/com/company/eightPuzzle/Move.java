package com.company.eightPuzzle;

public class Move {
    /* in this section we are going to build function that can move our empty state */
    private Rules rules = new Rules();
    Config config = new Config();

    public char [][]movement(char[][] initialState,int [] coordinate ,int move) {

        char [][] tempinitialState;
        tempinitialState =config.copyMatrix(initialState);




        int [] tempcordinate;
        tempcordinate=  config.copyCordinate(coordinate);
        int i = tempcordinate[0];
        int j = tempcordinate[1];
        switch (move)
        {
            case 1:
                if(rules.moveRule(tempinitialState,tempcordinate,1)) {
                    tempinitialState[i][j] = tempinitialState[i - 1][j];
                    tempinitialState[i - 1][j] = ' ';
                }
                break;

            case 2:
                if(rules.moveRule(tempinitialState,tempcordinate,2)) {
                    tempinitialState[i][j] = tempinitialState[i][j + 1];
                    tempinitialState[i][j + 1] = ' ';
                }
                break;
            case 3:
                if(rules.moveRule(tempinitialState,tempcordinate,3)) {
                    tempinitialState[i][j] = tempinitialState[i + 1][j];
                    tempinitialState[i + 1][j] = ' ';


                }
                break;
            case 4:
                if (rules.moveRule(tempinitialState,tempcordinate,4)) {
                    tempinitialState[i][j] = tempinitialState[i][j - 1];
                    tempinitialState[i][j - 1] = ' ';
                }
                break;


        }
        return tempinitialState;

    }



}

package com.company.eightQueen;

public class Move {
    public char [][]movement(char initialState[][],int [] coordinate ,int move) {

        Rules rules = new Rules();
        Config config = new Config();
        State state = new State();

        char tempinitialState[][] = config.copyMatrix(initialState);
         int tempcordinate [] = config.copyCordinate(coordinate);

        int i = tempcordinate[0];
        int j = tempcordinate[1];
        switch (move)
        {
            case 1:
                if(rules.moveRule(tempinitialState,tempcordinate,1)) {
                    tempinitialState[i][j] = tempinitialState[i - 1][j];
                    tempinitialState[i - 1][j] = '1';
                }
                break;

            case 2:
                if (rules.moveRule(tempinitialState,tempcordinate,2)) {
                    tempinitialState[i][j] = tempinitialState[i - 1][j + 1];
                    tempinitialState[i - 1][j + 1] = '1';
                }
                break;
            case 3:
                if (rules.moveRule(tempinitialState,tempcordinate,3)) {
                    tempinitialState[i][j] = tempinitialState[i][j + 1];
                    tempinitialState[i][j + 1] = '1';
                }
                break;
            case 4:
                if (rules.moveRule(tempinitialState,tempcordinate,4)) {
                    tempinitialState[i][j] = tempinitialState[i + 1][j + 1];
                    tempinitialState[i + 1][j + 1] = '1';
                }
                break;
            case 5:
                if (rules.moveRule(tempinitialState,tempcordinate,5)) {
                    tempinitialState[i][j] = tempinitialState[i + 1][j];
                    tempinitialState[i + 1][j] = '1';
                }
                break;
            case 6:
                if (rules.moveRule(tempinitialState,tempcordinate,6)) {
                    tempinitialState[i][j] = tempinitialState[i + 1][j - 1];
                    tempinitialState[i + 1][j - 1] = '1';
                }
                break;
            case 7:
                if (rules.moveRule(tempinitialState,tempcordinate,7)) {
                    tempinitialState[i][j] = tempinitialState[i][j - 1];
                    tempinitialState[i][j - 1] = '1';
                }
                break;
            case 8:
                if (rules.moveRule(tempinitialState,tempcordinate,8)) {
                    tempinitialState[i][j] = tempinitialState[i - 1][j - 1];
                    tempinitialState[i - 1][j - 1] = '1';
                }
                break;
        }
        return tempinitialState;
    }
}

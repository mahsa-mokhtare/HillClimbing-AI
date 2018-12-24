package com.company.eightPuzzle;

public class Move {
    /* in this section we are going to build function that can move our empty state */
    private Rules rules = new Rules();
    public char [][]movement(char initialState[][],int [] coordinate ,int move) {

        int i = coordinate[0];
        int j = coordinate[1];
        switch (move)
        {
            case 1:
                if(rules.moveRule(initialState,coordinate,1)) {
                    initialState[i][j] = initialState[i - 1][j];
                    initialState[i - 1][j] = ' ';
                }
                break;

            case 2:
                if(rules.moveRule(initialState,coordinate,2)) {
                    initialState[i][j] = initialState[i][j + 1];
                    initialState[i][j + 1] = ' ';
                }
                break;
            case 3:
                if(rules.moveRule(initialState,coordinate,3)) {
                    initialState[i][j] = initialState[i + 1][j];
                    initialState[i + 1][j] = ' ';
                }
                break;
            case 4:
                if (rules.moveRule(initialState,coordinate,4)) {
                    initialState[i][j] = initialState[i][j - 1];
                    initialState[i][j - 1] = ' ';
                }
                break;


        }
        return initialState;

    }



}

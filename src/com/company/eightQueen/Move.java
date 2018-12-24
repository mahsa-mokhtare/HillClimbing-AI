package com.company.eightQueen;

public class Move {
    public char [][]movement(char initialState[][],int [] coordinate ,int move) {

        Rules rules = new Rules();

        int i = coordinate[0];
        int j = coordinate[1];
        switch (move)
        {
            case 1:
                if(rules.moveRule(initialState,coordinate,1)) {
                    initialState[i][j] = initialState[i - 1][j];
                    initialState[i - 1][j] = '0';
                }
                break;

            case 2:
                if (rules.moveRule(initialState,coordinate,2)) {
                    initialState[i][j] = initialState[i - 1][j + 1];
                    initialState[i - 1][j + 1] = '0';
                }
                break;
            case 3:
                if (rules.moveRule(initialState,coordinate,3)) {
                    initialState[i][j] = initialState[i][j + 1];
                    initialState[i][j + 1] = '0';
                }
                break;
            case 4:
                if (rules.moveRule(initialState,coordinate,4)) {
                    initialState[i][j] = initialState[i + 1][j + 1];
                    initialState[i + 1][j + 1] = '0';
                }
                break;
            case 5:
                if (rules.moveRule(initialState,coordinate,5)) {
                    initialState[i][j] = initialState[i + 1][j];
                    initialState[i + 1][j] = '0';
                }
                break;
            case 6:
                if (rules.moveRule(initialState,coordinate,6)) {
                    initialState[i][j] = initialState[i + 1][j - 1];
                    initialState[i + 1][j - 1] = '0';
                }
                break;
            case 7:
                if (rules.moveRule(initialState,coordinate,7)) {
                    initialState[i][j] = initialState[i][j - 1];
                    initialState[i][j - 1] = '0';
                }
                break;
            case 8:
                if (rules.moveRule(initialState,coordinate,8)) {
                    initialState[i][j] = initialState[i - 1][j - 1];
                    initialState[i - 1][j - 1] = '0';
                }
                break;
        }

        return initialState;
    }
}

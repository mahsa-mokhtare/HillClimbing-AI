package com.company.eightPuzzle;

public class Search {

    //**********************************************************************************************************
    // This heuristic estimates the cost to the goal from current state by counting the number of misplaced tiles
    private int heuristicOne(char[][] currentState, char[][] goalState) {

        int differsent = 0;
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState.length; j++) {
                if (currentState[i][j] != goalState[i][j]) {
                    differsent += 1;
                }
            }
        }
        return differsent;
    }



    //***************************************************************************************************
    // This heuristic estimates the cost to the goal from current state by calculating the Manhathan distance

    public int oneManhatanDis(char[][] currentState,int xCurrent,int yCurrent, char[][] goalState)
    {
        //Save cordinate of goalState
        int cordinateGoal[] =new int[2];

        int different=0;

        for (int i=0; i<goalState.length;i++)
        {
            for (int j=0; j<goalState.length; j++)
            {
                if(goalState[i][j]==currentState[xCurrent][yCurrent])
                {
                    if(goalState[i][j] != ' ') {
                        cordinateGoal[0] = i;
                        cordinateGoal[1] = j;
                        different = different + ((Math.abs(i - xCurrent)) + (Math.abs(j - yCurrent)));
                    }
                }
            }
        }
        return different;
    }

    //*************************************************************************************************
    // This heuristic estimates the cost to the goal from current state by calculating the Manhathan distance from each misplaced
    // tile to its right position in the goal state

    public int ManhatanDistance(char[][]currentState,char[][]goalState)
    {
        int different=0;
        int [] cordinate = new int[2];
        for(int i=0; i<currentState.length;i++)
        {
            for(int j=0; j<currentState.length; j++)
            {
                cordinate[0]=i;
                cordinate[1]=j;
               different = different+ oneManhatanDis(currentState,cordinate[0],cordinate[1],goalState);
            }
        }
        return different;

  }

}

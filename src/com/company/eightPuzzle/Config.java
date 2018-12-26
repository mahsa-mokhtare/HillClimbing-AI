package com.company.eightPuzzle;

public class Config {


    public char[][] copyMatrix(char[][]current)
    {
        char [][]  copy = new char[3][3];
        for(int i=0;i<current.length;i++)
        {
            for(int j=0; j<current.length;j++)
            {
                copy[i][j]=current[i][j];
            }
        }
        return copy;

    }
    public int [] copyCordinate(int[]current)
    {
        int []copy = new int[2];
        copy[0]= current[0];
        copy[1] = current[1];
        return copy;

    }

    public char[][] goalState()
    {
        char [][] goal = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', ' '}};
        return goal;
    }

    public boolean isGoalState(char[][] matrix,char[][]goal)
    {

        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix.length; j++)
            {
                if (matrix[i][j]!=goal[i][j])
                {
                    return false;

                }
            }
        }
        return true;
    }
}

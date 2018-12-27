package com.company.eightQueen;

import java.util.ArrayList;

public class Config {




    public char[][] copyMatrix(char[][] current) {
        char[][] copy = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                copy[i][j] = current[i][j];
            }
        }
        return copy;

    }

    public ArrayList<int[]> copyList(ArrayList<int[]> list) {
        ArrayList<int[]> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(i));
        }
        return temp;

    }

    public int [] copyCordinate(int[]current)
    {
        int []copy = new int[2];
        copy[0]= current[0];
        copy[1] = current[1];
        return copy;

    }




}



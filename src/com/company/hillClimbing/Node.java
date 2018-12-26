package com.company.hillClimbing;

import com.company.eightPuzzle.Successor;

import java.util.ArrayList;

public class Node {

    public char[][] state;
    public int cost;
    public int value;

    public Node(char[][] state,int cost,int value){
        this.state = state;
        this.cost = cost;
        this.value = value;
    }



}

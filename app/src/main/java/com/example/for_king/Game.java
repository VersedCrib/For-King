package com.example.for_king;

import android.content.Intent;

import java.io.Serializable;

public class Game implements Serializable {
    boolean nextGame;
    String condition;
    int num_level;
    int situations;
    Gamers gamers;
    Text text = new Text();

    public Game(String name, String condition){
        gamers = new Gamers(name);
        this.condition = condition;
        setValue();
        nextGame();
    }

    public void nextGame(){
        nextGame = text.situations[num_level][situations].next;
    }

    public void setValue(){
        if(!condition.equals("")){
            this.condition = condition;
            num_level = condition.length()-1;
            situations = Integer.parseInt(Character.toString(condition.charAt(condition.length()-1)));
        }else {
            num_level = 0;
            situations = 0;
        }
    }

    public String getRB(int num){
        return text.situations[num_level][num].s;
    }

    public String getAnswer(){
        return text.situations[num_level][0].s;
    }

    public void setCondition(String s){
        this.condition = this.condition.concat(s);
    }

}

class Gamers{
    String name = "";
    int gold = 100;

    public Gamers(String name){
        this.name = name;
        //this.gold = gold;
    }

}

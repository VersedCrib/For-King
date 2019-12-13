package com.example.for_king;

import java.io.Serializable;

public class Game implements Serializable {
    boolean nextGame = true;
    String condition = "";
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

        if(gamers.gold>0 && text.situations[num_level][situations].next){
            this.nextGame = true;

        } else {
            this.nextGame = false;
        }
    }

    public void setValue(){
        if(condition.equals("")){
            num_level = 0;
            situations = 0;
        }else{
            num_level = condition.length();
            situations = Integer.parseInt(Character.toString(condition.charAt(condition.length()-1)));
        }
    }

    public String getRB(int num){
        return text.situations[num_level][num].s;
    }

    public String getAnswer() {
        return text.situations[num_level][0].s;
    }

    public void setCondition(String s){
        this.condition += s;
        setValue();
        nextGame();
    }

    public String getEnd(){
        return text.situations[num_level-1][situations].end;
    }

    public void action(){
        gamers.gold-=text.situations[num_level-1][situations].dellGold;
    }


}

class Gamers implements Serializable{
    String name = "";
    int gold = 100;

    public Gamers(String name){
        this.name = name;
        //this.gold = gold;
    }

}

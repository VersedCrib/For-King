package com.example.for_king;

import java.io.Serializable;

public class Text implements Serializable {
    Cell[][] situations = new Cell[10][10];
    public Text(){
        for(int i = 0; i<situations.length; i++){
            for(int k = 0; k<situations[i].length; k++){
                situations[i][k] = new Cell();
            }
        }

        situations[0][0].s = "На ваш путь выходит бандит и спрашивает с вас деньги.";
        situations[0][0].next = true;

        situations[0][1].s = "Ударить его";
        situations[0][1].next = false;
        situations[0][2].s = "Вызвать на дуэль";
        situations[0][2].next = false;
        situations[0][3].s = "Откупиться (-10 золотых)";
        situations[0][3].next = true;
        situations[0][3].dellGold = 10;

        situations[1][0].s = "На ваш путь выходит стражник и требует с вас выкуп.";

        situations[1][1].s = "Ударить его";
        situations[1][1].next = false;
        situations[1][2].s = "Вызвать на дуэль";
        situations[1][2].next = false;
        situations[1][3].s = "Откупиться (-20 золотых)";
        situations[1][3].next = true;
        situations[0][3].dellGold = 20;


        situations[2][0].s = "На ваш путь выходит судья и требует с вас выкуп.";

        situations[2][1].s = "Ударить его";
        situations[2][1].next = false;
        situations[2][2].s = "Вызвать на дуэль";
        situations[2][2].next = false;
        situations[2][3].s = "Откупиться (-30 золотых)";
        situations[2][3].next = true;
        situations[2][3].dellGold = 30;

    }



}

class Cell implements Serializable{
    String s = "";
    boolean next = true;
    int dellGold = 0;

}